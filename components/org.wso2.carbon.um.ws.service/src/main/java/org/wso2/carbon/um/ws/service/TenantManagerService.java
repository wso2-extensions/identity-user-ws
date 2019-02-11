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

package org.wso2.carbon.um.ws.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.core.AbstractAdmin;
import org.wso2.carbon.user.core.tenant.Tenant;
import org.wso2.carbon.user.core.tenant.TenantManager;

// TODO super tenant service
public class TenantManagerService extends AbstractAdmin {

    private static Log log = LogFactory.getLog(TenantManager.class);

    private static final String logMessage =
            "RemoteTenantManagerService is deprecated. Please use TenantMgtAdminService for tenant related operations";

    public void activateTenant(int tenantId) {

        log.error(logMessage);
        throw new RuntimeException(logMessage);
    }

    public int addTenant(Tenant tenant) {

        log.error(logMessage);
        throw new RuntimeException(logMessage);
    }

    public void deactivateTenant(int tenantId) {

        log.error(logMessage);
        throw new RuntimeException(logMessage);
    }

    public void deleteTenant(int tenantId) {

        log.error(logMessage);
        throw new RuntimeException(logMessage);
    }

    public Tenant[] getAllTenants() {

        log.error(logMessage);
        throw new RuntimeException(logMessage);
    }

    public String getDomain(int tenantId) {

        log.error(logMessage);
        throw new RuntimeException(logMessage);
    }

    public String getSuperTenantDomain() {

        log.error(logMessage);
        throw new RuntimeException(logMessage);
    }

    public Tenant getTenant(int tenantId) {

        log.error(logMessage);
        throw new RuntimeException(logMessage);
    }

    public int getTenantId(String domain) {

        log.error(logMessage);
        throw new RuntimeException(logMessage);
    }

    public boolean isTenantActive(int tenantId) {

        log.error(logMessage);
        throw new RuntimeException(logMessage);
    }

    public void updateTenant(Tenant tenant) {

        log.error(logMessage);
        throw new RuntimeException(logMessage);
    }

}
