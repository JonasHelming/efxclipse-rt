/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.text.ui;

import java.util.function.BiFunction;

import org.eclipse.fx.core.Subscription;
import org.eclipse.fx.core.text.TextEditAction;
import org.eclipse.fx.ui.controls.styledtext.StyledTextArea;
import org.eclipse.fx.ui.controls.styledtext.TriggerActionMapping.Context;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;

public interface ITextViewer {
	public IDocument getDocument();
	public void setDocument(IDocument document);
	void setDocument(IDocument document, int modelRangeOffset, int modelRangeLength);
	public IRegion getVisibleRegion();
	void addTextListener(ITextListener listener);
	public void removeTextListener(ITextListener listener);
	void addTextInputListener(ITextInputListener listener);
	void removeTextInputListener(ITextInputListener listener);
	void changeTextPresentation(TextPresentation presentation, boolean controlRedraw);
	StyledTextArea getTextWidget();
	public boolean overlapsWithVisibleRegion(int start, int length);
	public void invalidateTextPresentation();
	void setVisibleRegion(int offset, int length);
	void resetVisibleRegion();


	void setUndoManager(IUndoManager undoManager);
	IUndoManager getUndoManager();


	Subscription subscribeAction(BiFunction<TextEditAction, Context, Boolean> handler);

}
