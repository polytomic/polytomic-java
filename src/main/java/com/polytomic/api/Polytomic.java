
package com.polytomic.api;

import com.polytomic.api.core.ClientOptions;
import com.polytomic.api.core.Suppliers;
import com.polytomic.api.resources.bulksync.BulkSyncClient;
import com.polytomic.api.resources.connections.ConnectionsClient;
import com.polytomic.api.resources.events.EventsClient;
import com.polytomic.api.resources.models.ModelsClient;
import com.polytomic.api.resources.modelsync.ModelSyncClient;
import com.polytomic.api.resources.organization.OrganizationClient;
import com.polytomic.api.resources.permissions.PermissionsClient;
import com.polytomic.api.resources.schemas.SchemasClient;
import com.polytomic.api.resources.users.UsersClient;
import com.polytomic.api.resources.webhooks.WebhooksClient;
import java.util.function.Supplier;

public class Polytomic {
    protected final ClientOptions clientOptions;

    protected final Supplier<BulkSyncClient> bulkSyncClient;

    protected final Supplier<ConnectionsClient> connectionsClient;

    protected final Supplier<SchemasClient> schemasClient;

    protected final Supplier<EventsClient> eventsClient;

    protected final Supplier<ModelsClient> modelsClient;

    protected final Supplier<OrganizationClient> organizationClient;

    protected final Supplier<UsersClient> usersClient;

    protected final Supplier<PermissionsClient> permissionsClient;

    protected final Supplier<ModelSyncClient> modelSyncClient;

    protected final Supplier<WebhooksClient> webhooksClient;

    public Polytomic(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.bulkSyncClient = Suppliers.memoize(() -> new BulkSyncClient(clientOptions));
        this.connectionsClient = Suppliers.memoize(() -> new ConnectionsClient(clientOptions));
        this.schemasClient = Suppliers.memoize(() -> new SchemasClient(clientOptions));
        this.eventsClient = Suppliers.memoize(() -> new EventsClient(clientOptions));
        this.modelsClient = Suppliers.memoize(() -> new ModelsClient(clientOptions));
        this.organizationClient = Suppliers.memoize(() -> new OrganizationClient(clientOptions));
        this.usersClient = Suppliers.memoize(() -> new UsersClient(clientOptions));
        this.permissionsClient = Suppliers.memoize(() -> new PermissionsClient(clientOptions));
        this.modelSyncClient = Suppliers.memoize(() -> new ModelSyncClient(clientOptions));
        this.webhooksClient = Suppliers.memoize(() -> new WebhooksClient(clientOptions));
    }

    public BulkSyncClient bulkSync() {
        return this.bulkSyncClient.get();
    }

    public ConnectionsClient connections() {
        return this.connectionsClient.get();
    }

    public SchemasClient schemas() {
        return this.schemasClient.get();
    }

    public EventsClient events() {
        return this.eventsClient.get();
    }

    public ModelsClient models() {
        return this.modelsClient.get();
    }

    public OrganizationClient organization() {
        return this.organizationClient.get();
    }

    public UsersClient users() {
        return this.usersClient.get();
    }

    public PermissionsClient permissions() {
        return this.permissionsClient.get();
    }

    public ModelSyncClient modelSync() {
        return this.modelSyncClient.get();
    }

    public WebhooksClient webhooks() {
        return this.webhooksClient.get();
    }

    public static PolytomicBuilder builder() {
        return new PolytomicBuilder();
    }
}