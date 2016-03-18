/*******************************************************************************
* Copyright (c) 2016 BestSolution.at and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* 	Tom Schindl<tom.schindl@bestsolution.at> - initial API and implementation
*******************************************************************************/
package org.eclipse.fx.text.rules;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IToken;

/**
 * This is a specialized rule who can be used to implement rules who have to
 * have dynamic end who is built from information at the start rule
 * <p>
 * A good example for this is Lua multi-line comments and strings
 * </p>
 *
 * <pre>
 * {@code
 * [[
 *  THIS IS MULTILINE
 *  STRING
 * ]]
 * }
 * </pre>
 *
 * Where it is allowed to put as many = signs between the two [[ and ]] the only
 * requirement is that start and end matches
 *
 * <pre>
 * {@code
 * [=====[
 *  THIS IS MULTILINE
 *  STRING
 * ]=====]
 * }
 * </pre>
 *
 * would be expressed as
 *
 * <pre>
 * {@code
 * new DynamicEndRule( "[", Pattern.compile("(=*)\\["), "]{0}]" );
 * }
 * </pre>
 */
@SuppressWarnings("restriction")
public class DynamicEndRule extends ExtendedPatternRule {
	private final Pattern beginPattern;
	private final String endTemplate;

	/**
	 * Create a new dynamic end rule
	 *
	 * @param token
	 *            the token if succeeded
	 * @param beginPrefix
	 *            the prefix for the start must be at least one char
	 * @param beginPattern
	 *            the pattern with groups to find the end of the start-sequence
	 * @param endTemplate
	 *            the end template who can references groups from the start
	 *            sequence using {index} like in {@link MessageFormat}
	 */
	public DynamicEndRule(IToken token, String beginPrefix, Pattern beginPattern, String endTemplate) {
		super(beginPrefix, "", token, '\\', false, true);
		this.beginPattern = beginPattern;
		this.endTemplate = endTemplate;
	}

	@Override
	public IToken evaluate(ICharacterScanner scanner, boolean resume) {
		if (!resume) {
			fEndSequence = new char[0];
		}
		return super.evaluate(scanner, resume);
	}

	@Override
	protected boolean sequenceStartDetected(ICharacterScanner scanner, char[] sequence, boolean eofAllowed) {
		boolean rv = super.sequenceStartDetected(scanner, sequence, eofAllowed);

		if (rv) {
			CheckPointScanner checkPointScanner = new CheckPointScanner(scanner);
			checkPointScanner.setCheckpoint();

			StringBuilder b = new StringBuilder();
			int c;
			boolean hasOneMatch = false;
			while ((c = scanner.read()) != ICharacterScanner.EOF) {
				b.append(c);
				if (!beginPattern.matcher(b).matches()) {
					if (hasOneMatch) {
						Matcher matcher = beginPattern.matcher(b.subSequence(0, b.length() - 1));
						Object[] g = new String[matcher.groupCount()];
						for (int i = 0; i < matcher.groupCount(); i++) {
							g[i] = matcher.group(i + 1);
						}
						fEndSequence = MessageFormat.format(endTemplate, g).toCharArray();
						return true;
					} else {
						checkPointScanner.rollbackToCheckPoint();
						return false;
					}
				} else {
					hasOneMatch = true;
				}
			}
		}

		return rv;
	}
}