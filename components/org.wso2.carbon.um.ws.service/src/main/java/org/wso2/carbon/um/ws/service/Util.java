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
import org.wso2.carbon.base.MultitenantConstants;
import org.wso2.carbon.context.CarbonContext;
import org.wso2.carbon.user.api.Claim;
import org.wso2.carbon.user.api.ClaimMapping;
import org.wso2.carbon.user.core.UserStoreException;

/**
 * Utility class for remote user management.
 */
public class Util {


    private static final Log log = LogFactory.getLog(Util.class.getClass());
    private static final String PROTECTED_STRING = "protected";

    private Util() {
    }

    static void checkAccess(String resourceId) throws UserStoreException {

        if (isSuperTenantResource(resourceId) && !isSuperTenant()) {

            StringBuilder stringBuilder
                    = new StringBuilder("Unauthorized attempt to modify super tenant resource by tenant domain - ");
            stringBuilder.append(CarbonContext.getThreadLocalCarbonContext().getTenantDomain()).append(" tenant id - ")
                    .append(CarbonContext.getThreadLocalCarbonContext().getTenantId()).append(" user - ")
                    .append(CarbonContext.getThreadLocalCarbonContext().getUsername());
            log.warn(stringBuilder.toString());

            throw new UserStoreException("Access Denied");

        }
    }

    private static boolean isSuperTenantResource(String resource) {
        return resource.contains(PROTECTED_STRING);
    }

    static boolean isSuperTenant() {
        int tenantId = CarbonContext.getThreadLocalCarbonContext().getTenantId();
        return tenantId == MultitenantConstants.SUPER_TENANT_ID;
    }

    /**
     * Ensure the given claim is an actual instance of org.wso2.carbon.user.api.Claim.
     * @param claim
     * @return org.wso2.carbon.user.api.Claim.
     */
    static Claim ensureInstanceType(Claim claim) {
        if (claim == null) {
            return new Claim();
        }
        if (Claim.class.getName().equals(claim.getClass().getName())){
            return claim;
        }
        Claim apiClaim = new Claim();
        apiClaim.setClaimUri(claim.getClaimUri());
        apiClaim.setReadOnly(claim.isReadOnly());
        apiClaim.setCheckedAttribute(claim.isCheckedAttribute());
        apiClaim.setDisplayTag(claim.getDisplayTag());
        apiClaim.setDescription(claim.getDescription());
        apiClaim.setSupportedByDefault(claim.isSupportedByDefault());
        apiClaim.setRequired(claim.isRequired());
        apiClaim.setRegEx(claim.getRegEx());
        apiClaim.setDialectURI(claim.getDialectURI());
        apiClaim.setValue(claim.getValue());
        apiClaim.setDisplayOrder(claim.getDisplayOrder());
        return apiClaim;
    }

    /**
     * Ensure the given claim is an actual instance of org.wso2.carbon.user.api.ClaimMapping.
     * @param claimMapping
     * @return org.wso2.carbon.user.api.ClaimMapping
     */
    static ClaimMapping ensureInstanceType(ClaimMapping claimMapping){
        if (claimMapping == null) {
            return new ClaimMapping();
        }
        if (ClaimMapping.class.getName().equals(claimMapping.getClass().getName())){
            return claimMapping;
        }
        ClaimMapping apiClaimMapping = new ClaimMapping(
                ensureInstanceType(claimMapping.getClaim()),
                claimMapping.getMappedAttribute());
        apiClaimMapping.setMappedAttributes(claimMapping.getMappedAttributes());
        return apiClaimMapping;
    }

    /**
     * Ensure the given claim is an array of actual instances of org.wso2.carbon.user.api.ClaimMapping.
     * @param claimMappings
     * @return possible null || org.wso2.carbon.user.api.ClaimMapping[]
     */
    static ClaimMapping[] ensureInstanceType(ClaimMapping[] claimMappings){
        if (claimMappings == null) {
            return claimMappings;
        }
        ClaimMapping[] apiClaimMappings = new ClaimMapping[claimMappings.length];
        for (int i=0; i<claimMappings.length; i++){
            apiClaimMappings[i] = ensureInstanceType(claimMappings[i]);
        }
        return apiClaimMappings;
    }
}
