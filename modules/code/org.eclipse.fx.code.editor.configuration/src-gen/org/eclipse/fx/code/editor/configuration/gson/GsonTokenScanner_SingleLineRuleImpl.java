package org.eclipse.fx.code.editor.configuration.gson;

import org.eclipse.fx.code.editor.configuration.*;
import com.google.gson.JsonObject;

public final class GsonTokenScanner_SingleLineRuleImpl implements GsonBase, TokenScanner_SingleLineRule, TokenScanner {
	public GsonTokenScanner_SingleLineRuleImpl(JsonObject jsonObject) {
		this.check = jsonObject.has("check") ? GsonElementFactory.createCheck(jsonObject.getAsJsonObject("check")) : null;
		this.condition = jsonObject.has("condition") ? GsonElementFactory.createCondition(jsonObject.getAsJsonObject("condition")) : null;
		this.endSeq = jsonObject.has("endSeq") ? jsonObject.get("endSeq").getAsString() : null;
		this.escapedBy = jsonObject.has("escapedBy") ? jsonObject.get("escapedBy").getAsString() : null;
		this.startSeq = jsonObject.has("startSeq") ? jsonObject.get("startSeq").getAsString() : null;
	}
	public GsonTokenScanner_SingleLineRuleImpl(Check check, Condition condition, String endSeq, String escapedBy, String startSeq) {
		this.check = check;
		this.condition = condition;
		this.endSeq = endSeq;
		this.escapedBy = escapedBy;
		this.startSeq = startSeq;
	}

	public JsonObject toJSONObject() {
		JsonObject o = new JsonObject();
		o.addProperty( "$gtype", "TokenScanner_SingleLineRule" );
		o.add( "check", getCheck() == null ? null : ((GsonBase)getCheck()).toJSONObject() );
		o.add( "condition", getCondition() == null ? null : ((GsonBase)getCondition()).toJSONObject() );
		o.addProperty( "endSeq", getEndSeq() );
		o.addProperty( "escapedBy", getEscapedBy() );
		o.addProperty( "startSeq", getStartSeq() );
		return o;
	}

	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " { "
					 + "check : " + (check == null ? null : check.getClass().getSimpleName() + "@" + Integer.toHexString(check.hashCode())) + ", "
					 + "condition : " + (condition == null ? null : condition.getClass().getSimpleName() + "@" + Integer.toHexString(condition.hashCode())) + ", "
					 + "endSeq : " + endSeq + ", "
					 + "escapedBy : " + escapedBy + ", "
					 + "startSeq : " + startSeq
					+" }";
	}

	private final Check check;
	public Check getCheck() {
		return this.check;
	}
	

	private final Condition condition;
	public Condition getCondition() {
		return this.condition;
	}
	

	private final String endSeq;
	public String getEndSeq() {
		return this.endSeq;
	}
	

	private final String escapedBy;
	public String getEscapedBy() {
		return this.escapedBy;
	}
	

	private final String startSeq;
	public String getStartSeq() {
		return this.startSeq;
	}
	


	public static class Builder implements TokenScanner_SingleLineRule.Builder {
		private final EditorGModel instance;

		public Builder(EditorGModel instance) {
			this.instance = instance;
		}
		private Check check;
		public Builder check(Check check) {
			this.check = check;
			return this;
		}
		private Condition condition;
		public Builder condition(Condition condition) {
			this.condition = condition;
			return this;
		}
		private String endSeq;
		public Builder endSeq(String endSeq) {
			this.endSeq = endSeq;
			return this;
		}
		private String escapedBy;
		public Builder escapedBy(String escapedBy) {
			this.escapedBy = escapedBy;
			return this;
		}
		private String startSeq;
		public Builder startSeq(String startSeq) {
			this.startSeq = startSeq;
			return this;
		}

		public TokenScanner_SingleLineRule build() {
			return new GsonTokenScanner_SingleLineRuleImpl(check, condition, endSeq, escapedBy, startSeq);
		}
	}
}
