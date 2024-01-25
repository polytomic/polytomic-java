
package com.polytomic.api.resources.permissions;

import com.polytomic.api.core.ClientOptions;
import com.polytomic.api.core.Suppliers;
import com.polytomic.api.resources.permissions.policies.PoliciesClient;
import com.polytomic.api.resources.permissions.roles.RolesClient;
import java.util.function.Supplier;

public class PermissionsClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<PoliciesClient> policiesClient;

    protected final Supplier<RolesClient> rolesClient;

    public PermissionsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.policiesClient = Suppliers.memoize(() -> new PoliciesClient(clientOptions));
        this.rolesClient = Suppliers.memoize(() -> new RolesClient(clientOptions));
    }

    public PoliciesClient policies() {
        return this.policiesClient.get();
    }

    public RolesClient roles() {
        return this.rolesClient.get();
    }
}
