package io.github.mrbraz.framework.infra.ioc;

public interface PostInjection<I> {
	void visit(I instance);
}