package com.codetest.karma.myapplication.di.scopes;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by karma on 25/10/2017.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityDetailScope {
}
