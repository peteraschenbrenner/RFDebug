package com.rfdebug.rfdebug.shared.service;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface EntityRequestFactory extends RequestFactory {

  EntitiesRequestContext entitiesRequestContext();
}
