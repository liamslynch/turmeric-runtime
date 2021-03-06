/*******************************************************************************
 * Copyright (c) 2006-2010 eBay Inc. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *******************************************************************************/
package org.ebayopensource.turmeric.runtime.config.validation.verifiers;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.ebayopensource.turmeric.runtime.config.validation.AbstractVerifier;
import org.jdom.Document;

public class GlobalClientConfigVerifier extends AbstractVerifier {
	private static final Logger LOG = Logger.getLogger(GlobalClientConfigVerifier.class.getName());

	@Override
	public String getFileRegex() {
		return "META-INF/soa/client/([^/]+)/GlobalClientConfig.xml";
	}

	@Override
	public void verifyHit(File hit) {
		LOG.fine("Verifying: " + hit);
		try {
			Document doc = xmlParse(hit);
			
            String expectedRootName = "global-client-config";
            String expectedDefaultNamespace = "http://www.ebayopensource.org/turmeric/common/config";
            if (!validRootElement(hit, doc, expectedRootName, expectedDefaultNamespace)) {
                return;
            }

			// @formatter:off
			String xpaths[] = {
				"//c:class-name/text()",
				"//c:serializer-factory-class-name/text()",
				"//c:deserializer-factory-class-name/text()"
			};
			// @formatter:on
			
			for(String xpath: xpaths) {
				assertClassExists(hit, doc, xpath);
			}
		} catch(Exception e) {
			LOG.log(Level.WARNING, "Unable to parse XML: " + hit, e);
		}
	}
}
