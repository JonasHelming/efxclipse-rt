package org.eclipse.fx.code.editor.ldef.langs.fx.go;

public class GoPresentationReconciler extends org.eclipse.jface.text.presentation.PresentationReconciler {
	public GoPresentationReconciler() {
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __dftl_partition_content_typeDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Go__dftl_partition_content_type());
		setDamager(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		setRepairer(__dftl_partition_content_typeDamageRepairer, "__dftl_partition_content_type");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __go_single_line_commentDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Go__go_single_line_comment());
		setDamager(__go_single_line_commentDamageRepairer, "__go_single_line_comment");
		setRepairer(__go_single_line_commentDamageRepairer, "__go_single_line_comment");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __go_multi_line_commentDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Go__go_multi_line_comment());
		setDamager(__go_multi_line_commentDamageRepairer, "__go_multi_line_comment");
		setRepairer(__go_multi_line_commentDamageRepairer, "__go_multi_line_comment");
		org.eclipse.jface.text.rules.DefaultDamagerRepairer __go_stringDamageRepairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(new Go__go_string());
		setDamager(__go_stringDamageRepairer, "__go_string");
		setRepairer(__go_stringDamageRepairer, "__go_string");
	}
}