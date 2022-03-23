/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.sling.nosql.generic.simple;

import org.apache.sling.spi.resource.provider.ResourceProvider;
import org.apache.sling.nosql.generic.resource.impl.AbstractNoSqlResourceProviderRootTest;
import org.apache.sling.nosql.generic.simple.provider.SimpleNoSqlResourceProviderFactory;

import com.google.common.collect.ImmutableMap;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

/**
 * Test basic ResourceResolver and ValueMap with different data types.
 */
public class SimpleNoSqlResourceProviderRootTest extends AbstractNoSqlResourceProviderRootTest {

    @Override
    protected void registerResourceProviderFactoryAsRoot() {
        ResourceProvider<?> resourceProvider = mock(ResourceProvider.class);
        context.registerService(ResourceProvider.class, resourceProvider,ResourceProvider.PROPERTY_ROOT, "/");

        context.registerInjectActivateService(new SimpleNoSqlResourceProviderFactory(), ImmutableMap.<String, Object>builder()
                .put(ResourceProvider.PROPERTY_ROOT, "/nosql-simple")
                        .put("enabled", true)
                .build());
    }
}
