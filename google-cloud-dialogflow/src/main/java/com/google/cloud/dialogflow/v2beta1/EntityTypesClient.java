/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dialogflow.v2beta1;

import static com.google.cloud.dialogflow.v2beta1.PagedResponseWrappers.ListEntityTypesPagedResponse;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.EntityType.Entity;
import com.google.cloud.dialogflow.v2beta1.stub.EntityTypesStub;
import com.google.cloud.dialogflow.v2beta1.stub.EntityTypesStubSettings;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Manages agent entity types.
 *
 * <p>Refer to the [Dialogflow documentation](https://dialogflow.com/docs/entities) for more details
 * about entity types. #
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
 *   EntityTypeName name = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
 *   EntityType response = entityTypesClient.getEntityType(name);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the entityTypesClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of EntityTypesSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * EntityTypesSettings entityTypesSettings =
 *     EntityTypesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * EntityTypesClient entityTypesClient =
 *     EntityTypesClient.create(entityTypesSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * EntityTypesSettings entityTypesSettings =
 *     EntityTypesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EntityTypesClient entityTypesClient =
 *     EntityTypesClient.create(entityTypesSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class EntityTypesClient implements BackgroundResource {
  private final EntityTypesSettings settings;
  private final EntityTypesStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of EntityTypesClient with default settings. */
  public static final EntityTypesClient create() throws IOException {
    return create(EntityTypesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of EntityTypesClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final EntityTypesClient create(EntityTypesSettings settings) throws IOException {
    return new EntityTypesClient(settings);
  }

  /**
   * Constructs an instance of EntityTypesClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use EntityTypesSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final EntityTypesClient create(EntityTypesStub stub) {
    return new EntityTypesClient(stub);
  }

  /**
   * Constructs an instance of EntityTypesClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected EntityTypesClient(EntityTypesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((EntityTypesStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected EntityTypesClient(EntityTypesStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final EntityTypesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public EntityTypesStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the list of all entity types in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
   *   for (EntityType element : entityTypesClient.listEntityTypes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The agent to list all entity types from. Format: `projects/&lt;Project
   *     ID&gt;/agent`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntityTypesPagedResponse listEntityTypes(ProjectAgentName parent) {
    ListEntityTypesRequest request =
        ListEntityTypesRequest.newBuilder().setParent(parent.toString()).build();
    return listEntityTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the list of all entity types in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
   *   String languageCode = "";
   *   for (EntityType element : entityTypesClient.listEntityTypes(parent, languageCode).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The agent to list all entity types from. Format: `projects/&lt;Project
   *     ID&gt;/agent`.
   * @param languageCode Optional. The language to list entity synonyms for. If not specified, the
   *     agent's default language is used. [More than a dozen
   *     languages](https://dialogflow.com/docs/reference/language) are supported. Note: languages
   *     must be enabled in the agent, before they can be used.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntityTypesPagedResponse listEntityTypes(
      ProjectAgentName parent, String languageCode) {
    ListEntityTypesRequest request =
        ListEntityTypesRequest.newBuilder()
            .setParent(parent.toString())
            .setLanguageCode(languageCode)
            .build();
    return listEntityTypes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the list of all entity types in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
   *   ListEntityTypesRequest request = ListEntityTypesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (EntityType element : entityTypesClient.listEntityTypes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntityTypesPagedResponse listEntityTypes(ListEntityTypesRequest request) {
    return listEntityTypesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the list of all entity types in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
   *   ListEntityTypesRequest request = ListEntityTypesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListEntityTypesPagedResponse&gt; future = entityTypesClient.listEntityTypesPagedCallable().futureCall(request);
   *   // Do something
   *   for (EntityType element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListEntityTypesRequest, ListEntityTypesPagedResponse>
      listEntityTypesPagedCallable() {
    return stub.listEntityTypesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the list of all entity types in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
   *   ListEntityTypesRequest request = ListEntityTypesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListEntityTypesResponse response = entityTypesClient.listEntityTypesCallable().call(request);
   *     for (EntityType element : response.getEntityTypesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListEntityTypesRequest, ListEntityTypesResponse>
      listEntityTypesCallable() {
    return stub.listEntityTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified entity type.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName name = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   EntityType response = entityTypesClient.getEntityType(name);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the entity type. Format: `projects/&lt;Project
   *     ID&gt;/agent/entityTypes/&lt;EntityType ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType getEntityType(EntityTypeName name) {

    GetEntityTypeRequest request =
        GetEntityTypeRequest.newBuilder().setName(name.toString()).build();
    return getEntityType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified entity type.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName name = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   String languageCode = "";
   *   EntityType response = entityTypesClient.getEntityType(name, languageCode);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the entity type. Format: `projects/&lt;Project
   *     ID&gt;/agent/entityTypes/&lt;EntityType ID&gt;`.
   * @param languageCode Optional. The language to retrieve entity synonyms for. If not specified,
   *     the agent's default language is used. [More than a dozen
   *     languages](https://dialogflow.com/docs/reference/language) are supported. Note: languages
   *     must be enabled in the agent, before they can be used.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType getEntityType(EntityTypeName name, String languageCode) {

    GetEntityTypeRequest request =
        GetEntityTypeRequest.newBuilder()
            .setName(name.toString())
            .setLanguageCode(languageCode)
            .build();
    return getEntityType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified entity type.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName name = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   GetEntityTypeRequest request = GetEntityTypeRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   EntityType response = entityTypesClient.getEntityType(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType getEntityType(GetEntityTypeRequest request) {
    return getEntityTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified entity type.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName name = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   GetEntityTypeRequest request = GetEntityTypeRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;EntityType&gt; future = entityTypesClient.getEntityTypeCallable().futureCall(request);
   *   // Do something
   *   EntityType response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetEntityTypeRequest, EntityType> getEntityTypeCallable() {
    return stub.getEntityTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an entity type in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
   *   EntityType entityType = EntityType.newBuilder().build();
   *   EntityType response = entityTypesClient.createEntityType(parent, entityType);
   * }
   * </code></pre>
   *
   * @param parent Required. The agent to create a entity type for. Format: `projects/&lt;Project
   *     ID&gt;/agent`.
   * @param entityType Required. The entity type to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType createEntityType(ProjectAgentName parent, EntityType entityType) {

    CreateEntityTypeRequest request =
        CreateEntityTypeRequest.newBuilder()
            .setParent(parent.toString())
            .setEntityType(entityType)
            .build();
    return createEntityType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an entity type in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
   *   EntityType entityType = EntityType.newBuilder().build();
   *   String languageCode = "";
   *   EntityType response = entityTypesClient.createEntityType(parent, entityType, languageCode);
   * }
   * </code></pre>
   *
   * @param parent Required. The agent to create a entity type for. Format: `projects/&lt;Project
   *     ID&gt;/agent`.
   * @param entityType Required. The entity type to create.
   * @param languageCode Optional. The language of entity synonyms defined in `entity_type`. If not
   *     specified, the agent's default language is used. [More than a dozen
   *     languages](https://dialogflow.com/docs/reference/language) are supported. Note: languages
   *     must be enabled in the agent, before they can be used.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType createEntityType(
      ProjectAgentName parent, EntityType entityType, String languageCode) {

    CreateEntityTypeRequest request =
        CreateEntityTypeRequest.newBuilder()
            .setParent(parent.toString())
            .setEntityType(entityType)
            .setLanguageCode(languageCode)
            .build();
    return createEntityType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an entity type in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
   *   EntityType entityType = EntityType.newBuilder().build();
   *   CreateEntityTypeRequest request = CreateEntityTypeRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setEntityType(entityType)
   *     .build();
   *   EntityType response = entityTypesClient.createEntityType(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType createEntityType(CreateEntityTypeRequest request) {
    return createEntityTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates an entity type in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
   *   EntityType entityType = EntityType.newBuilder().build();
   *   CreateEntityTypeRequest request = CreateEntityTypeRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setEntityType(entityType)
   *     .build();
   *   ApiFuture&lt;EntityType&gt; future = entityTypesClient.createEntityTypeCallable().futureCall(request);
   *   // Do something
   *   EntityType response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateEntityTypeRequest, EntityType> createEntityTypeCallable() {
    return stub.createEntityTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified entity type.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityType entityType = EntityType.newBuilder().build();
   *   EntityType response = entityTypesClient.updateEntityType(entityType);
   * }
   * </code></pre>
   *
   * @param entityType Required. The entity type to update. Format: `projects/&lt;Project
   *     ID&gt;/agent/entityTypes/&lt;EntityType ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType updateEntityType(EntityType entityType) {

    UpdateEntityTypeRequest request =
        UpdateEntityTypeRequest.newBuilder().setEntityType(entityType).build();
    return updateEntityType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified entity type.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityType entityType = EntityType.newBuilder().build();
   *   String languageCode = "";
   *   EntityType response = entityTypesClient.updateEntityType(entityType, languageCode);
   * }
   * </code></pre>
   *
   * @param entityType Required. The entity type to update. Format: `projects/&lt;Project
   *     ID&gt;/agent/entityTypes/&lt;EntityType ID&gt;`.
   * @param languageCode Optional. The language of entity synonyms defined in `entity_type`. If not
   *     specified, the agent's default language is used. [More than a dozen
   *     languages](https://dialogflow.com/docs/reference/language) are supported. Note: languages
   *     must be enabled in the agent, before they can be used.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType updateEntityType(EntityType entityType, String languageCode) {

    UpdateEntityTypeRequest request =
        UpdateEntityTypeRequest.newBuilder()
            .setEntityType(entityType)
            .setLanguageCode(languageCode)
            .build();
    return updateEntityType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified entity type.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityType entityType = EntityType.newBuilder().build();
   *   UpdateEntityTypeRequest request = UpdateEntityTypeRequest.newBuilder()
   *     .setEntityType(entityType)
   *     .build();
   *   EntityType response = entityTypesClient.updateEntityType(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntityType updateEntityType(UpdateEntityTypeRequest request) {
    return updateEntityTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified entity type.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityType entityType = EntityType.newBuilder().build();
   *   UpdateEntityTypeRequest request = UpdateEntityTypeRequest.newBuilder()
   *     .setEntityType(entityType)
   *     .build();
   *   ApiFuture&lt;EntityType&gt; future = entityTypesClient.updateEntityTypeCallable().futureCall(request);
   *   // Do something
   *   EntityType response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateEntityTypeRequest, EntityType> updateEntityTypeCallable() {
    return stub.updateEntityTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified entity type.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName name = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   entityTypesClient.deleteEntityType(name);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the entity type to delete. Format: `projects/&lt;Project
   *     ID&gt;/agent/entityTypes/&lt;EntityType ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEntityType(EntityTypeName name) {

    DeleteEntityTypeRequest request =
        DeleteEntityTypeRequest.newBuilder().setName(name.toString()).build();
    deleteEntityType(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified entity type.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName name = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   DeleteEntityTypeRequest request = DeleteEntityTypeRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   entityTypesClient.deleteEntityType(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final void deleteEntityType(DeleteEntityTypeRequest request) {
    deleteEntityTypeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified entity type.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName name = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   DeleteEntityTypeRequest request = DeleteEntityTypeRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = entityTypesClient.deleteEntityTypeCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteEntityTypeRequest, Empty> deleteEntityTypeCallable() {
    return stub.deleteEntityTypeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates/Creates multiple entity types in the specified agent.
   *
   * <p>Operation &lt;response:
   * [BatchUpdateEntityTypesResponse][google.cloud.dialogflow.v2beta1.BatchUpdateEntityTypesResponse],
   * metadata: [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
   *   BatchUpdateEntityTypesRequest request = BatchUpdateEntityTypesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   BatchUpdateEntityTypesResponse response = entityTypesClient.batchUpdateEntityTypesAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchUpdateEntityTypesResponse, Struct> batchUpdateEntityTypesAsync(
      BatchUpdateEntityTypesRequest request) {
    return batchUpdateEntityTypesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates/Creates multiple entity types in the specified agent.
   *
   * <p>Operation &lt;response:
   * [BatchUpdateEntityTypesResponse][google.cloud.dialogflow.v2beta1.BatchUpdateEntityTypesResponse],
   * metadata: [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
   *   BatchUpdateEntityTypesRequest request = BatchUpdateEntityTypesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = entityTypesClient.batchUpdateEntityTypesOperationCallable().futureCall(request);
   *   // Do something
   *   BatchUpdateEntityTypesResponse response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<
          BatchUpdateEntityTypesRequest, BatchUpdateEntityTypesResponse, Struct>
      batchUpdateEntityTypesOperationCallable() {
    return stub.batchUpdateEntityTypesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates/Creates multiple entity types in the specified agent.
   *
   * <p>Operation &lt;response:
   * [BatchUpdateEntityTypesResponse][google.cloud.dialogflow.v2beta1.BatchUpdateEntityTypesResponse],
   * metadata: [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
   *   BatchUpdateEntityTypesRequest request = BatchUpdateEntityTypesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = entityTypesClient.batchUpdateEntityTypesCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BatchUpdateEntityTypesRequest, Operation>
      batchUpdateEntityTypesCallable() {
    return stub.batchUpdateEntityTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes entity types in the specified agent.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
   *   List&lt;String&gt; entityTypeNames = new ArrayList&lt;&gt;();
   *   Empty response = entityTypesClient.batchDeleteEntityTypesAsync(parent, entityTypeNames).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the agent to delete all entities types for. Format:
   *     `projects/&lt;Project ID&gt;/agent`.
   * @param entityTypeNames Required. The names entity types to delete. All names must point to the
   *     same agent as `parent`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchDeleteEntityTypesAsync(
      ProjectAgentName parent, List<String> entityTypeNames) {

    BatchDeleteEntityTypesRequest request =
        BatchDeleteEntityTypesRequest.newBuilder()
            .setParent(parent.toString())
            .addAllEntityTypeNames(entityTypeNames)
            .build();
    return batchDeleteEntityTypesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes entity types in the specified agent.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
   *   List&lt;String&gt; entityTypeNames = new ArrayList&lt;&gt;();
   *   BatchDeleteEntityTypesRequest request = BatchDeleteEntityTypesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .addAllEntityTypeNames(entityTypeNames)
   *     .build();
   *   Empty response = entityTypesClient.batchDeleteEntityTypesAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchDeleteEntityTypesAsync(
      BatchDeleteEntityTypesRequest request) {
    return batchDeleteEntityTypesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes entity types in the specified agent.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
   *   List&lt;String&gt; entityTypeNames = new ArrayList&lt;&gt;();
   *   BatchDeleteEntityTypesRequest request = BatchDeleteEntityTypesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .addAllEntityTypeNames(entityTypeNames)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = entityTypesClient.batchDeleteEntityTypesOperationCallable().futureCall(request);
   *   // Do something
   *   Empty response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<BatchDeleteEntityTypesRequest, Empty, Struct>
      batchDeleteEntityTypesOperationCallable() {
    return stub.batchDeleteEntityTypesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes entity types in the specified agent.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   ProjectAgentName parent = ProjectAgentName.of("[PROJECT]");
   *   List&lt;String&gt; entityTypeNames = new ArrayList&lt;&gt;();
   *   BatchDeleteEntityTypesRequest request = BatchDeleteEntityTypesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .addAllEntityTypeNames(entityTypeNames)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = entityTypesClient.batchDeleteEntityTypesCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BatchDeleteEntityTypesRequest, Operation>
      batchDeleteEntityTypesCallable() {
    return stub.batchDeleteEntityTypesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates multiple new entities in the specified entity type (extends the existing collection of
   * entries).
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   List&lt;EntityType.Entity&gt; entities = new ArrayList&lt;&gt;();
   *   Empty response = entityTypesClient.batchCreateEntitiesAsync(parent, entities).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the entity type to create entities in. Format:
   *     `projects/&lt;Project ID&gt;/agent/entityTypes/&lt;Entity Type ID&gt;`.
   * @param entities Required. The collection of entities to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchCreateEntitiesAsync(
      EntityTypeName parent, List<EntityType.Entity> entities) {

    BatchCreateEntitiesRequest request =
        BatchCreateEntitiesRequest.newBuilder()
            .setParent(parent.toString())
            .addAllEntities(entities)
            .build();
    return batchCreateEntitiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates multiple new entities in the specified entity type (extends the existing collection of
   * entries).
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   List&lt;EntityType.Entity&gt; entities = new ArrayList&lt;&gt;();
   *   String languageCode = "";
   *   Empty response = entityTypesClient.batchCreateEntitiesAsync(parent, entities, languageCode).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the entity type to create entities in. Format:
   *     `projects/&lt;Project ID&gt;/agent/entityTypes/&lt;Entity Type ID&gt;`.
   * @param entities Required. The collection of entities to create.
   * @param languageCode Optional. The language of entity synonyms defined in `entities`. If not
   *     specified, the agent's default language is used. [More than a dozen
   *     languages](https://dialogflow.com/docs/reference/language) are supported. Note: languages
   *     must be enabled in the agent, before they can be used.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchCreateEntitiesAsync(
      EntityTypeName parent, List<EntityType.Entity> entities, String languageCode) {

    BatchCreateEntitiesRequest request =
        BatchCreateEntitiesRequest.newBuilder()
            .setParent(parent.toString())
            .addAllEntities(entities)
            .setLanguageCode(languageCode)
            .build();
    return batchCreateEntitiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates multiple new entities in the specified entity type (extends the existing collection of
   * entries).
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   List&lt;EntityType.Entity&gt; entities = new ArrayList&lt;&gt;();
   *   BatchCreateEntitiesRequest request = BatchCreateEntitiesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .addAllEntities(entities)
   *     .build();
   *   Empty response = entityTypesClient.batchCreateEntitiesAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchCreateEntitiesAsync(
      BatchCreateEntitiesRequest request) {
    return batchCreateEntitiesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates multiple new entities in the specified entity type (extends the existing collection of
   * entries).
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   List&lt;EntityType.Entity&gt; entities = new ArrayList&lt;&gt;();
   *   BatchCreateEntitiesRequest request = BatchCreateEntitiesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .addAllEntities(entities)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = entityTypesClient.batchCreateEntitiesOperationCallable().futureCall(request);
   *   // Do something
   *   Empty response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<BatchCreateEntitiesRequest, Empty, Struct>
      batchCreateEntitiesOperationCallable() {
    return stub.batchCreateEntitiesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates multiple new entities in the specified entity type (extends the existing collection of
   * entries).
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   List&lt;EntityType.Entity&gt; entities = new ArrayList&lt;&gt;();
   *   BatchCreateEntitiesRequest request = BatchCreateEntitiesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .addAllEntities(entities)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = entityTypesClient.batchCreateEntitiesCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BatchCreateEntitiesRequest, Operation> batchCreateEntitiesCallable() {
    return stub.batchCreateEntitiesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates entities in the specified entity type (replaces the existing collection of entries).
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   List&lt;EntityType.Entity&gt; entities = new ArrayList&lt;&gt;();
   *   Empty response = entityTypesClient.batchUpdateEntitiesAsync(parent, entities).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the entity type to update the entities in. Format:
   *     `projects/&lt;Project ID&gt;/agent/entityTypes/&lt;Entity Type ID&gt;`.
   * @param entities Required. The collection of new entities to replace the existing entities.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchUpdateEntitiesAsync(
      EntityTypeName parent, List<EntityType.Entity> entities) {

    BatchUpdateEntitiesRequest request =
        BatchUpdateEntitiesRequest.newBuilder()
            .setParent(parent.toString())
            .addAllEntities(entities)
            .build();
    return batchUpdateEntitiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates entities in the specified entity type (replaces the existing collection of entries).
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   List&lt;EntityType.Entity&gt; entities = new ArrayList&lt;&gt;();
   *   String languageCode = "";
   *   Empty response = entityTypesClient.batchUpdateEntitiesAsync(parent, entities, languageCode).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the entity type to update the entities in. Format:
   *     `projects/&lt;Project ID&gt;/agent/entityTypes/&lt;Entity Type ID&gt;`.
   * @param entities Required. The collection of new entities to replace the existing entities.
   * @param languageCode Optional. The language of entity synonyms defined in `entities`. If not
   *     specified, the agent's default language is used. [More than a dozen
   *     languages](https://dialogflow.com/docs/reference/language) are supported. Note: languages
   *     must be enabled in the agent, before they can be used.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchUpdateEntitiesAsync(
      EntityTypeName parent, List<EntityType.Entity> entities, String languageCode) {

    BatchUpdateEntitiesRequest request =
        BatchUpdateEntitiesRequest.newBuilder()
            .setParent(parent.toString())
            .addAllEntities(entities)
            .setLanguageCode(languageCode)
            .build();
    return batchUpdateEntitiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates entities in the specified entity type (replaces the existing collection of entries).
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   List&lt;EntityType.Entity&gt; entities = new ArrayList&lt;&gt;();
   *   BatchUpdateEntitiesRequest request = BatchUpdateEntitiesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .addAllEntities(entities)
   *     .build();
   *   Empty response = entityTypesClient.batchUpdateEntitiesAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchUpdateEntitiesAsync(
      BatchUpdateEntitiesRequest request) {
    return batchUpdateEntitiesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates entities in the specified entity type (replaces the existing collection of entries).
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   List&lt;EntityType.Entity&gt; entities = new ArrayList&lt;&gt;();
   *   BatchUpdateEntitiesRequest request = BatchUpdateEntitiesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .addAllEntities(entities)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = entityTypesClient.batchUpdateEntitiesOperationCallable().futureCall(request);
   *   // Do something
   *   Empty response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<BatchUpdateEntitiesRequest, Empty, Struct>
      batchUpdateEntitiesOperationCallable() {
    return stub.batchUpdateEntitiesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates entities in the specified entity type (replaces the existing collection of entries).
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   List&lt;EntityType.Entity&gt; entities = new ArrayList&lt;&gt;();
   *   BatchUpdateEntitiesRequest request = BatchUpdateEntitiesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .addAllEntities(entities)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = entityTypesClient.batchUpdateEntitiesCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BatchUpdateEntitiesRequest, Operation> batchUpdateEntitiesCallable() {
    return stub.batchUpdateEntitiesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes entities in the specified entity type.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   List&lt;String&gt; entityValues = new ArrayList&lt;&gt;();
   *   Empty response = entityTypesClient.batchDeleteEntitiesAsync(parent, entityValues).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the entity type to delete entries for. Format:
   *     `projects/&lt;Project ID&gt;/agent/entityTypes/&lt;Entity Type ID&gt;`.
   * @param entityValues Required. The canonical `values` of the entities to delete. Note that these
   *     are not fully-qualified names, i.e. they don't start with `projects/&lt;Project ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchDeleteEntitiesAsync(
      EntityTypeName parent, List<String> entityValues) {

    BatchDeleteEntitiesRequest request =
        BatchDeleteEntitiesRequest.newBuilder()
            .setParent(parent.toString())
            .addAllEntityValues(entityValues)
            .build();
    return batchDeleteEntitiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes entities in the specified entity type.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   List&lt;String&gt; entityValues = new ArrayList&lt;&gt;();
   *   String languageCode = "";
   *   Empty response = entityTypesClient.batchDeleteEntitiesAsync(parent, entityValues, languageCode).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the entity type to delete entries for. Format:
   *     `projects/&lt;Project ID&gt;/agent/entityTypes/&lt;Entity Type ID&gt;`.
   * @param entityValues Required. The canonical `values` of the entities to delete. Note that these
   *     are not fully-qualified names, i.e. they don't start with `projects/&lt;Project ID&gt;`.
   * @param languageCode Optional. The language of entity synonyms defined in `entities`. If not
   *     specified, the agent's default language is used. [More than a dozen
   *     languages](https://dialogflow.com/docs/reference/language) are supported. Note: languages
   *     must be enabled in the agent, before they can be used.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchDeleteEntitiesAsync(
      EntityTypeName parent, List<String> entityValues, String languageCode) {

    BatchDeleteEntitiesRequest request =
        BatchDeleteEntitiesRequest.newBuilder()
            .setParent(parent.toString())
            .addAllEntityValues(entityValues)
            .setLanguageCode(languageCode)
            .build();
    return batchDeleteEntitiesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes entities in the specified entity type.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   List&lt;String&gt; entityValues = new ArrayList&lt;&gt;();
   *   BatchDeleteEntitiesRequest request = BatchDeleteEntitiesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .addAllEntityValues(entityValues)
   *     .build();
   *   Empty response = entityTypesClient.batchDeleteEntitiesAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> batchDeleteEntitiesAsync(
      BatchDeleteEntitiesRequest request) {
    return batchDeleteEntitiesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes entities in the specified entity type.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   List&lt;String&gt; entityValues = new ArrayList&lt;&gt;();
   *   BatchDeleteEntitiesRequest request = BatchDeleteEntitiesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .addAllEntityValues(entityValues)
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = entityTypesClient.batchDeleteEntitiesOperationCallable().futureCall(request);
   *   // Do something
   *   Empty response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<BatchDeleteEntitiesRequest, Empty, Struct>
      batchDeleteEntitiesOperationCallable() {
    return stub.batchDeleteEntitiesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes entities in the specified entity type.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (EntityTypesClient entityTypesClient = EntityTypesClient.create()) {
   *   EntityTypeName parent = EntityTypeName.of("[PROJECT]", "[ENTITY_TYPE]");
   *   List&lt;String&gt; entityValues = new ArrayList&lt;&gt;();
   *   BatchDeleteEntitiesRequest request = BatchDeleteEntitiesRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .addAllEntityValues(entityValues)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = entityTypesClient.batchDeleteEntitiesCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BatchDeleteEntitiesRequest, Operation> batchDeleteEntitiesCallable() {
    return stub.batchDeleteEntitiesCallable();
  }

  @Override
  public final void close() throws Exception {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }
}
