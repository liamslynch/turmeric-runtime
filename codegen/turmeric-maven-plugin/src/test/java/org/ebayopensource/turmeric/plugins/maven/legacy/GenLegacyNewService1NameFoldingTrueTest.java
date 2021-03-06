/*******************************************************************************
 * Copyright (c) 2006-2010 eBay Inc. All Rights Reserved.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *******************************************************************************/
package org.ebayopensource.turmeric.plugins.maven.legacy;

import org.ebayopensource.turmeric.plugins.maven.BaseGenInterfaceFromWsdlMojoTestCase;
import org.ebayopensource.turmeric.plugins.maven.GenInterfaceFromWsdlMojo;
import org.junit.Test;

/**
 * Test Namefolding as legacy true and enableNamespaceFolding  true
 */
public class GenLegacyNewService1NameFoldingTrueTest extends
		BaseGenInterfaceFromWsdlMojoTestCase {
	@Override
	public String getTestMojoDirName() {
		return "legacy/NewServiceV1NameFoldingTrue";
	}

	@Test
	public void testLegacyGenInterfaceNameFoldingTrue() throws Exception {
		GenInterfaceFromWsdlMojo mojo = createMojo();
		testProjectExecuteMojo(mojo);
		assertPostCodegenRules(mojo);
	}
}
