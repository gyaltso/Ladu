/*******************************************************************************
 * Copyright (C) 2020 Gyaltso Technologies (https://gyaltso.com/)
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package com.gyaltso.lcp.ladu.ui;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * @author Neeraj Bhusare - Initial contribution and API
 *
 */
public class LaduPerspective implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(true);

		final IFolderLayout westFolder = layout.createFolder("topLeft", //
				IPageLayout.LEFT, //
				0.26f, //
				layout.getEditorArea());
		westFolder.addView("org.eclipse.jdt.ui.PackageExplorer");

		final IFolderLayout bottomLeft = layout.createFolder("bottomLeft", //
				IPageLayout.BOTTOM, //
				0.65f, //
				"topLeft");
		bottomLeft.addView(IPageLayout.ID_OUTLINE);
		bottomLeft.addView("org.eclipse.egit.ui.RepositoriesView");

		final IFolderLayout southFolder = layout.createFolder("bottomRight", //
				IPageLayout.BOTTOM, //
				0.65f, //
				layout.getEditorArea());
		southFolder.addView(IPageLayout.ID_PROBLEM_VIEW);
		southFolder.addView("org.eclipse.ui.console.ConsoleView");
	}

}
