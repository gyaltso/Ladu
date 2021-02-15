/*******************************************************************************
 * Copyright (C) 2020, 2021 Gyaltso Technologies (https://gyaltso.com/)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package com.gyaltso.lcp.ladu.project.project.wizard;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.internal.ide.IDEWorkbenchPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.gyaltso.lcp.ladu.project.Activator;
import com.gyaltso.lcp.ladu.project.project.LaduProject;

/**
 * @author Neeraj Bhusare - Initial contribution and API.
 */
public class LaduProjectCreationWizard extends Wizard implements INewWizard {

	private LaduProjectCreationWizardPage wizardPage;

	private IWorkbench workbench;

	public LaduProjectCreationWizard() {
		Bundle b = FrameworkUtil.getBundle(LaduProjectCreationWizard.class);
		URL url = FileLocator.find(b, new Path("icons/wizard/banner.png"));
		setDefaultPageImageDescriptor(ImageDescriptor.createFromURL(url));
		setWindowTitle("New Bitu Project");
		setNeedsProgressMonitor(true);
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.workbench = workbench;
	}

	@Override
	public void addPages() {
		addPage(wizardPage = new LaduProjectCreationWizardPage());
	}

	@Override
	public boolean performFinish() {
		String artifactId = wizardPage.getArtifactId();

		try {
			getContainer().run(true, true, (monitor) -> {
				LaduProject bituProject = new LaduProject("com.gyaltso.lcp", artifactId, "0.0.1");
				bituProject.setWorkbench(workbench);
				bituProject.setWorkspace(ResourcesPlugin.getWorkspace());
				bituProject.setProjectName(artifactId);
				bituProject.createProject(monitor, getShell());
			});
		} catch (InvocationTargetException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	private static class LaduProjectCreationWizardPage extends WizardPage {

		private Text projectName;

		private ProjectNameValidator projectNameValidator = new ProjectNameValidator();

		protected LaduProjectCreationWizardPage() {
			super("Ladu Project");
			setTitle("Ladu Project");
			setDescription("Create a new Ladu project");
			setPageComplete(false);
		}

		@Override
		public void createControl(Composite parent) {
			Composite childComposite = new Composite(parent, SWT.None);
			childComposite.setLayout(new GridLayout(2, false));

			new Label(childComposite, SWT.WRAP).setText("Project name:");
			projectName = new Text(childComposite, SWT.BORDER);
			projectName.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
			projectName.addModifyListener(new ModifyListener() {

				@Override
				public void modifyText(ModifyEvent e) {
					IStatus status = projectNameValidator.isValidName(projectName.getText());
					if (!status.isOK()) {
						setErrorMessage(status.getMessage());
						setPageComplete(false);
					} else {
						setErrorMessage(null);
						setMessage(null);
						setPageComplete(true);
					}
				}
			});

			setControl(childComposite);
		}

		public String getArtifactId() {
			return projectName.getText();
		}

	}

	private static class ProjectNameValidator {

		protected IStatus isValidName(String projectName) {
			IWorkspace workspace = IDEWorkbenchPlugin.getPluginWorkspace();
			if (workspace != null) {
				// Validate the name
				IStatus nameStatus = workspace.validateName(projectName, IResource.PROJECT);
				if (!nameStatus.isOK()) {
					return nameStatus;
				}

				// Check for existing projects with same name
				IProject projectHandle = getProjectHandle(projectName);
				if (projectHandle.exists()) {
					return new Status(IStatus.ERROR, //
							Activator.PLUGIN_ID, //
							"The project with that name exists in the workspace");
				}

			}
			return Status.OK_STATUS;
		}

		public static IProject getProjectHandle(String projectName) {
			return ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		}

	}

}
