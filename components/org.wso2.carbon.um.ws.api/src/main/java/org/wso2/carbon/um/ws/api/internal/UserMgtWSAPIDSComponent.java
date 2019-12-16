/*
 * Copyright (c) 2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.um.ws.api.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.wso2.carbon.utils.ConfigurationContextService;

@Component(
        name = "remote.um.api.component",
        immediate = true)
public class UserMgtWSAPIDSComponent {

    private static final Log log = LogFactory.getLog(UserMgtWSAPIDSComponent.class);

    private static final String ACTIVATION_MESSGE = "Remote User mgt bundle is activated ";

    public static ConfigurationContextService getCcServiceInstance() {

        return UserMgtWSAPIDataHolder.getInstance().getCcServiceInstance();
    }

    @Activate
    protected void activate(ComponentContext ctxt) {

        log.debug(ACTIVATION_MESSGE);
    }

    @Deactivate
    protected void deactivate(ComponentContext ctxt) {

        return;
    }

    @Reference(
            name = "config.context.service",
            service = org.wso2.carbon.utils.ConfigurationContextService.class,
            cardinality = ReferenceCardinality.MANDATORY,
            policy = ReferencePolicy.DYNAMIC,
            unbind = "unsetConfigurationContextService")
    protected void setConfigurationContextService(ConfigurationContextService contextService) {

        UserMgtWSAPIDataHolder.getInstance().setCcServiceInstance(contextService);
    }

    protected void unsetConfigurationContextService(ConfigurationContextService contextService) {

        UserMgtWSAPIDataHolder.getInstance().setCcServiceInstance(null);
    }
}
