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
import org.wso2.carbon.um.ws.service.internal.UMRemoteServicesDSComponent;
import org.wso2.carbon.user.core.UserStoreException;
import org.wso2.carbon.user.core.tenant.Tenant;
import org.wso2.carbon.user.core.tenant.TenantManager;

/**
 * RemoteTenantManagerService admin service.
 * @deprecated as of version 5.3.5. Use {@link org.wso2.carbon.tenant.mgt.services.TenantMgtAdminService}
 */
public class TenantManagerService extends AbstractAdmin {

    private static Log log = LogFactory.getLog(TenantManager.class);

    private static final String logMessage =
            "RemoteTenantManagerService is deprecated. Please use TenantMgtAdminService for tenant related operations";

    public void activateTenant(int tenantId) throws UserStoreException {

        log.warn(logMessage);

        try {
            getTenantManager().activateTenant(tenantId);
        } catch (org.wso2.carbon.user.api.UserStoreException e) {
            throw new UserStoreException(e);
        }
    }

    public int addTenant(Tenant tenant) throws UserStoreException {

        log.warn(logMessage);

        try {
            return getTenantManager().addTenant(tenant);
        } catch (org.wso2.carbon.user.api.UserStoreException e) {
            throw new UserStoreException(e);
        }
    }

    public void deactivateTenant(int tenantId) throws UserStoreException {

        log.warn(logMessage);

        try {
            getTenantManager().deactivateTenant(tenantId);
        } catch (org.wso2.carbon.user.api.UserStoreException e) {
            throw new UserStoreException(e);
        }
    }

    public void deleteTenant(int tenantId) throws UserStoreException {

        log.warn(logMessage);

        try {
            getTenantManager().deleteTenant(tenantId);
        } catch (org.wso2.carbon.user.api.UserStoreException e) {
            throw new UserStoreException(e);
        }
    }

    public Tenant[] getAllTenants() throws UserStoreException {

        log.warn(logMessage);

        try {
            return (Tenant[]) getTenantManager().getAllTenants();
        } catch (org.wso2.carbon.user.api.UserStoreException e) {
            throw new UserStoreException(e);
        }
    }

    public String getDomain(int tenantId) throws UserStoreException {

        try {
            return getTenantManager().getDomain(tenantId);
        } catch (org.wso2.carbon.user.api.UserStoreException e) {
            throw new UserStoreException(e);
        }
    }

    public String getSuperTenantDomain() throws UserStoreException {

        log.warn(logMessage);

        return getTenantManager().getSuperTenantDomain();
    }

    public Tenant getTenant(int tenantId) throws UserStoreException {

        log.warn(logMessage);

        try {
            return (Tenant) getTenantManager().getTenant(tenantId);
        } catch (org.wso2.carbon.user.api.UserStoreException e) {
            throw new UserStoreException(e);
        }
    }

    public int getTenantId(String domain) throws UserStoreException {

        log.warn(logMessage);

        try {
            return getTenantManager().getTenantId(domain);
        } catch (org.wso2.carbon.user.api.UserStoreException e) {
            throw new UserStoreException(e);
        }
    }

    public boolean isTenantActive(int tenantId) throws UserStoreException {

        log.warn(logMessage);

        try {
            return getTenantManager().isTenantActive(tenantId);
        } catch (org.wso2.carbon.user.api.UserStoreException e) {
            throw new UserStoreException(e);
        }
    }

    public void updateTenant(Tenant tenant) throws UserStoreException {

        log.warn(logMessage);

        try {
            getTenantManager().updateTenant(tenant);
        } catch (org.wso2.carbon.user.api.UserStoreException e) {
            throw new UserStoreException(e);
        }
    }

    private TenantManager getTenantManager() {

        return UMRemoteServicesDSComponent.getRealmService().getTenantManager();
    }
}
