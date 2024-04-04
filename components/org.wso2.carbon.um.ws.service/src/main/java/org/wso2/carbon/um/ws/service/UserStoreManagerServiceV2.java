/*
 * Copyright (c) 2024, WSO2 LLC. (http://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.um.ws.service;

import org.wso2.carbon.core.AbstractAdmin;
import org.wso2.carbon.um.ws.service.dao.ClaimDTO;
import org.wso2.carbon.um.ws.service.dao.PermissionDTO;
import org.wso2.carbon.user.core.UserStoreException;
import org.wso2.carbon.user.core.tenant.Tenant;
import org.wso2.carbon.user.mgt.common.ClaimValue;

public class UserStoreManagerServiceV2 extends AbstractAdmin {

    UserStoreManagerService userStoreManagerService = new UserStoreManagerService();

    /**
     * Adds a new user.
     *
     * @param userName              The username of the user.
     * @param credential            The credential/password of the user.
     * @param roleList              The roles to be assigned to the user.
     * @param claims                The properties of the user.
     * @param profileName           The profile name for the user.
     * @param requirePasswordChange Whether to require a password change.
     * @return True if the operation completes successfully.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public boolean addUser(String userName, String credential, String[] roleList, ClaimValue[] claims,
                           String profileName, boolean requirePasswordChange) throws UserStoreException {

        userStoreManagerService.addUser(userName, credential, roleList, claims, profileName, requirePasswordChange);
        return Boolean.TRUE;
    }

    /**
     * Sets multiple user claim values.
     *
     * @param userName    The username of the user.
     * @param claims      The claims to be set.
     * @param profileName The profile name of the user.
     * @return True if the operation completes successfully.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public boolean setUserClaimValues(String userName, ClaimValue[] claims, String profileName)
            throws UserStoreException {

        userStoreManagerService.setUserClaimValues(userName, claims, profileName);
        return Boolean.TRUE;
    }

    /**
     * Adds multiple user claim values.
     *
     * @param userName    The username of the user.
     * @param claims      The claims to be added.
     * @param profileName The profile name of the user.
     * @return True if the operation completes successfully.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public boolean addUserClaimValues(String userName, ClaimValue[] claims, String profileName)
            throws UserStoreException {

        userStoreManagerService.addUserClaimValues(userName, claims, profileName);
        return Boolean.TRUE;
    }

    /**
     * Get user claim values in the profile.
     *
     * @param userName    The username.
     * @param claims      The claim URI.
     * @param profileName The profile name, can be null. If null the default profile is considered.
     * @return A map containing name value pairs.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public ClaimValue[] getUserClaimValuesForClaims(String userName, String[] claims, String profileName)
            throws UserStoreException {

        return userStoreManagerService.getUserClaimValuesForClaims(userName, claims, profileName);
    }

    /**
     * Adds a new role.
     *
     * @param roleName    The name of the role to be added.
     * @param userList    The users to be assigned the added role.
     * @param permissions The permissions of the role.
     * @return True if the operation completes successfully.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public boolean addRole(String roleName, String[] userList, PermissionDTO[] permissions)
            throws UserStoreException {

        userStoreManagerService.addRole(roleName, userList, permissions);
        return Boolean.TRUE;
    }

    /**
     * Get all claim values of the user in the profile.
     *
     * @param userName    The username.
     * @param profileName The profile name, can be null. If null the default profile is considered.
     * @return An array of claims.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public ClaimDTO[] getUserClaimValues(String userName, String profileName) throws UserStoreException {

        return userStoreManagerService.getUserClaimValues(userName, profileName);
    }

    /**
     * Validates user authentication using the provided username and credentials.
     *
     * @param userName   The username.
     * @param credential The credential of a user.
     * @return True if the provided credentials match the username, false otherwise.
     * @throws UserStoreException An unexpected exception has occurred.
     */
    public boolean authenticate(String userName, String credential) throws UserStoreException {

        return userStoreManagerService.authenticate(userName, credential);
    }

    /**
     * Updates a user's credential/password.
     *
     * @param userName      The username of the user.
     * @param newCredential The new credential to be set.
     * @param oldCredential The old credential to be changed.
     * @return True if the operation completes successfully.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public boolean updateCredential(String userName, String newCredential, String oldCredential)
            throws UserStoreException {

        userStoreManagerService.updateCredential(userName, newCredential, oldCredential);
        return Boolean.TRUE;
    }

    /**
     * Updates a user's credential/password as an admin.
     *
     * @param userName      The username of the user.
     * @param newCredential The new credential to be set.
     * @return True if the operation completes successfully.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public boolean updateCredentialByAdmin(String userName, String newCredential) throws UserStoreException {

        userStoreManagerService.updateCredentialByAdmin(userName, newCredential);
        return Boolean.TRUE;
    }

    /**
     * Get password expiration time.
     *
     * @param username The username.
     * @return Expiration date.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public long getPasswordExpirationTime(String username) throws UserStoreException {

        return userStoreManagerService.getPasswordExpirationTime(username);
    }

    /**
     * Deletes a role.
     *
     * @param roleName The name of the role to be deleted.
     * @return True if the operation completes successfully.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public boolean deleteRole(String roleName) throws UserStoreException {

        userStoreManagerService.deleteRole(roleName);
        return Boolean.TRUE;
    }

    /**
     * Deletes a user.
     *
     * @param userName The name of the user to be deleted.
     * @return True if the operation completes successfully.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public boolean deleteUser(String userName) throws UserStoreException {

        userStoreManagerService.deleteUser(userName);
        return Boolean.TRUE;
    }

    /**
     * Deletes a single user claim value.
     *
     * @param userName    The username of the user.
     * @param claimURI    The name of the claim.
     * @param profileName The profile name of the user.
     * @return True if the operation completes successfully.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public boolean deleteUserClaimValue(String userName, String claimURI, String profileName)
            throws UserStoreException {

        userStoreManagerService.deleteUserClaimValue(userName, claimURI, profileName);
        return Boolean.TRUE;
    }

    /**
     * Deletes multiple user claim values.
     *
     * @param userName    The username of the user.
     * @param claims      The names of the claims.
     * @param profileName The profile name of the user.
     * @return True if the operation completes successfully.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public boolean deleteUserClaimValues(String userName, String[] claims, String profileName)
            throws UserStoreException {

        userStoreManagerService.deleteUserClaimValues(userName, claims, profileName);
        return Boolean.TRUE;
    }

    /**
     * Get all the profile names in the system.
     *
     * @return An array of all profile names.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public String[] getAllProfileNames() throws UserStoreException {

        return userStoreManagerService.getAllProfileNames();
    }

    /**
     * Get all the hybrid roles.
     *
     * @return Array of hybrid roles.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public String[] getHybridRoles() throws UserStoreException {

        return userStoreManagerService.getHybridRoles();
    }

    /**
     * Get all profile names.
     *
     * @param userName The username.
     * @return An array of profile names the user has.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public String[] getProfileNames(String userName) throws UserStoreException {

        return userStoreManagerService.getProfileNames(userName);
    }

    /**
     * Get the roles of a user.
     *
     * @param userName The username.
     * @return An array of roles the user has.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public String[] getRoleListOfUser(String userName) throws UserStoreException {

        return userStoreManagerService.getRoleListOfUser(userName);
    }

    /**
     * Get all the role names.
     *
     * @return An array of all role names.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public String[] getRoleNames() throws UserStoreException {

        return userStoreManagerService.getRoleNames();
    }

    /**
     * This will get the tenant id associated with the user store manager.
     *
     * @return the tenant id of the authorization manager.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public int getTenantId() throws UserStoreException {

        return userStoreManagerService.getTenantId();
    }

    /**
     * Retrieves a list of user names for given user claim value.
     *
     * @param claimUri   Claim uri.
     * @param claimValue Claim value.
     * @param profile    Profile name, can be null. If null the default profile is considered.
     * @return An array of usernames.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public String[] getUserList(String claimUri, String claimValue, String profile)
            throws UserStoreException {

        return userStoreManagerService.getUserList(claimUri, claimValue, profile);
    }

    /**
     * Get the tenant id of the user.
     *
     * @param username The username.
     * @return The tenant id of the user.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public int getTenantIdofUser(String username) throws UserStoreException {

        return userStoreManagerService.getTenantIdofUser(username);
    }

    /**
     * Get user claim value in the profile.
     *
     * @param userName    The username.
     * @param claim       The claim URI.
     * @param profileName The profile name, can be null. If null the default profile is considered.
     * @return The value of the claim.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public String getUserClaimValue(String userName, String claim, String profileName)
            throws UserStoreException {

        return userStoreManagerService.getUserClaimValue(userName, claim, profileName);
    }

    /**
     * Get the user id of given user.
     *
     * @param username The username.
     * @return The user id of the user.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public int getUserId(String username) throws UserStoreException {

        return userStoreManagerService.getUserId(username);
    }

    /**
     * Get Users assigned to a given the role.
     *
     * @param roleName Name of the role.
     * @return Array of usernames.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public String[] getUserListOfRole(String roleName) throws UserStoreException {

        return userStoreManagerService.getUserListOfRole(roleName);
    }

    /**
     * Checks whether the role name is in the user store
     *
     * @param roleName The name of the role.
     * @return True if the role exists. False otherwise.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public boolean isExistingRole(String roleName) throws UserStoreException {

        return userStoreManagerService.isExistingRole(roleName);
    }

    /**
     * Checks whether the username is in the user store.
     *
     * @param userName The username.
     * @return True if the user exists. False otherwise.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public boolean isExistingUser(String userName) throws UserStoreException {

        return userStoreManagerService.isExistingUser(userName);
    }

    /**
     * Checks whether the user store is read only.
     *
     * @return True if the user store is read only. False otherwise.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public boolean isReadOnly() throws UserStoreException {

        return userStoreManagerService.isReadOnly();
    }

    /**
     * Retrieves a list of usernames upto a maximum limit
     *
     * @param filter       The string to filter out user
     * @param maxItemLimit The max item limit.
     * @return An array of usernames.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public String[] listUsers(String filter, int maxItemLimit) throws UserStoreException {

        return userStoreManagerService.listUsers(filter, maxItemLimit);
    }

    /**
     * Sets a single user claim value.
     *
     * @param userName    The username of the user.
     * @param claimURI    The name of the claim to be set.
     * @param claimValue  The claim value to be set.
     * @param profileName The profile name of the user.
     * @return True if the operation completes successfully.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public boolean setUserClaimValue(String userName, String claimURI, String claimValue,
                                     String profileName) throws UserStoreException {

        userStoreManagerService.setUserClaimValue(userName, claimURI, claimValue, profileName);
        return Boolean.TRUE;
    }

    /**
     * Adds a single user claim value.
     *
     * @param userName    The username of the user.
     * @param claimURI    The name of the claim.
     * @param claimValue  The claim value.
     * @param profileName The profile name of the user.
     * @return True if the operation completes successfully.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public boolean addUserClaimValue(String userName, String claimURI, String claimValue, String profileName)
            throws UserStoreException {

        userStoreManagerService.addUserClaimValue(userName, claimURI, claimValue, profileName);
        return Boolean.TRUE;
    }

    /**
     * Updates the roles of a user.
     *
     * @param userName     The username of the user.
     * @param deletedRoles The roles to be removed from the user.
     * @param newRoles     The roles to be added to the user.
     * @return True if the operation completes successfully.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public boolean updateRoleListOfUser(String userName, String[] deletedRoles, String[] newRoles)
            throws UserStoreException {

        userStoreManagerService.updateRoleListOfUser(userName, deletedRoles, newRoles);
        return Boolean.TRUE;
    }

    /**
     * Updates the name of a role.
     *
     * @param roleName    The name of the role to be updated.
     * @param newRoleName The new name of the role.
     * @return True if the operation completes successfully.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public boolean updateRoleName(String roleName, String newRoleName) throws UserStoreException {

        userStoreManagerService.updateRoleName(roleName, newRoleName);
        return Boolean.TRUE;
    }

    /**
     * Updates the users assigned to a role.
     *
     * @param roleName     The name of the role.
     * @param deletedUsers The users to be removed from the role.
     * @param newUsers     The users to be added to the role.
     * @return True if the operation completes successfully.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public boolean updateUserListOfRole(String roleName, String[] deletedUsers, String[] newUsers)
            throws UserStoreException {

        userStoreManagerService.updateUserListOfRole(roleName, deletedUsers, newUsers);
        return Boolean.TRUE;
    }

    /**
     * Get the properties of the tenant.
     *
     * @param tenant The tenant.
     * @return An array of properties.
     * @throws UserStoreException If an error occurs during the operation.
     */
    public String[][] getProperties(Tenant tenant) throws UserStoreException {

        return userStoreManagerService.getProperties(tenant);
    }

}
