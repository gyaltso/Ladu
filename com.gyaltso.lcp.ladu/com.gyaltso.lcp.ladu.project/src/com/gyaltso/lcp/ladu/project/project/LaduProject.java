package com.gyaltso.lcp.ladu.project.project;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.ui.util.JavaProjectFactory;

import com.google.common.collect.Lists;

/**
 * @author Neeraj Bhusare - Initial contribution and API
 */
public class LaduProject extends JavaProjectFactory {

	private final Logger logger = Logger.getLogger(LaduProject.class.getName());

	private final String groupId, artifactId, version;

	public LaduProject(String groupId, String artifactId, String version) {
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.version = version;

		addProjectNatures("org.eclipse.jdt.core.javanature", //
				"org.eclipse.m2e.core.maven2Nature", //
				"org.eclipse.xtext.ui.shared.xtextNature", //
				"com.gyaltso.lcp.ladu.project.nature");

		addBuilderIds("org.eclipse.xtext.ui.shared.xtextBuilder", //
				"org.eclipse.jdt.core.javabuilder", //
				"org.eclipse.m2e.core.maven2Builder");

		setDefaultOutput("target/classes");
		addSourceFolder("src/main/java", null, false);
		addSourceFolder("src/main/resources", null, false);
		addFolders(Lists.newArrayList("entities"));
	}

	@Override
	protected void enhanceProject(IProject project, SubMonitor subMonitor, Shell shell) throws CoreException {
		super.enhanceProject(project, subMonitor, shell);

		createFile("pom.xml", project, PomFile.getContent(groupId, artifactId, version).toString(), subMonitor);
		createFile(project.getName() + ".entity", project.getFolder("entities"), "package " + project.getName(),
				subMonitor);

		IFolder resources = project.getFolder("src/main/resources");
		createFile("application.properties", resources, getAppPropFileContents(), subMonitor);

		IFolder folder = resources.getFolder("public");
		if (!folder.exists()) {
			folder.create(true, true, subMonitor);
		} else {
			logger.log(Level.SEVERE, "public folder not created");
		}
	}

	@Override
	protected void addMoreClasspathEntriesTo(List<IClasspathEntry> classpathEntries) {
		classpathEntries.add(JavaCore.newContainerEntry(new Path("org.eclipse.m2e.MAVEN2_CLASSPATH_CONTAINER")));
	}

	private String getAppPropFileContents() {
		return "spring.h2.console.enabled=true\r\n" //
				+ "spring.h2.console.path=/h2-console\r\n" //
				+ "spring.datasource.url=jdbc:h2:mem:test;DB_CLOSE_DELAY=-1\r\n" //
				+ "spring.jpa.hibernate.ddl-auto=update";
	}

}
