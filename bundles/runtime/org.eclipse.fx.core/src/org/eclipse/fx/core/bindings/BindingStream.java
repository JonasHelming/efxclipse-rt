/*******************************************************************************
 * Copyright (c) 2016 BestSolution.at and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Christoph Caks<ccaks@bestsolution.at> - initial API and implementation
 *******************************************************************************/
package org.eclipse.fx.core.bindings;

import java.util.function.Function;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

/**
 * allows chaining of binding operations
 *
 * @param <T>
 */
public interface BindingStream<T> {

	/**
	 * applies a mapping function to another observable value.
	 *
	 * @param map
	 * @return the {@link BindingStream}
	 */
	<S> BindingStream<S> map(Function<T, ObservableValue<S>> map);

	/**
	 * applies a mapping function to a non observable value.
	 * changes won't be tracked!
	 * @param map
	 * @return the {@link BindingStream}
	 */
	<S> BindingStream<S> mapNoObservable(Function<T, S> map);

	/**
	 * creates the {@link ObjectBinding}
	 * @return the binding
	 */
	ObjectBinding<T> toBinding();


	<S> Property<S> toProperty(Function<T, Property<S>> map);

	<S> ObjectProperty<S> toObjectProperty(Function<T, ObjectProperty<S>> map);

	StringProperty toStringProperty(Function<T, StringProperty> map);

	DoubleProperty toDoubleProperty(Function<T, DoubleProperty> map);

	BooleanProperty toBooleanProperty(Function<T, BooleanProperty> map);

	FloatProperty toFloatProperty(Function<T, FloatProperty> map);

	LongProperty toLongProperty(Function<T, LongProperty> map);

	IntegerProperty toIntegerProperty(Function<T, IntegerProperty> map);
}