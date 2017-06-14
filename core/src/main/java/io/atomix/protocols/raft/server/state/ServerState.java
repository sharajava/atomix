/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
package io.atomix.protocols.raft.server.state;

import io.atomix.protocols.raft.protocol.AppendRequest;
import io.atomix.protocols.raft.protocol.AppendResponse;
import io.atomix.protocols.raft.protocol.CloseSessionRequest;
import io.atomix.protocols.raft.protocol.CloseSessionResponse;
import io.atomix.protocols.raft.protocol.CommandRequest;
import io.atomix.protocols.raft.protocol.CommandResponse;
import io.atomix.protocols.raft.protocol.ConfigureRequest;
import io.atomix.protocols.raft.protocol.ConfigureResponse;
import io.atomix.protocols.raft.protocol.InstallRequest;
import io.atomix.protocols.raft.protocol.InstallResponse;
import io.atomix.protocols.raft.protocol.JoinRequest;
import io.atomix.protocols.raft.protocol.JoinResponse;
import io.atomix.protocols.raft.protocol.KeepAliveRequest;
import io.atomix.protocols.raft.protocol.KeepAliveResponse;
import io.atomix.protocols.raft.protocol.LeaveRequest;
import io.atomix.protocols.raft.protocol.LeaveResponse;
import io.atomix.protocols.raft.protocol.MetadataRequest;
import io.atomix.protocols.raft.protocol.MetadataResponse;
import io.atomix.protocols.raft.protocol.OpenSessionRequest;
import io.atomix.protocols.raft.protocol.OpenSessionResponse;
import io.atomix.protocols.raft.protocol.PollRequest;
import io.atomix.protocols.raft.protocol.PollResponse;
import io.atomix.protocols.raft.protocol.QueryRequest;
import io.atomix.protocols.raft.protocol.QueryResponse;
import io.atomix.protocols.raft.protocol.ReconfigureRequest;
import io.atomix.protocols.raft.protocol.ReconfigureResponse;
import io.atomix.protocols.raft.protocol.VoteRequest;
import io.atomix.protocols.raft.protocol.VoteResponse;
import io.atomix.protocols.raft.server.RaftServer;
import io.atomix.util.Managed;

import java.util.concurrent.CompletableFuture;

/**
 * Server state interface.
 *
 * @author <a href="http://github.com/kuujo>Jordan Halterman</a>
 */
public interface ServerState extends Managed<ServerState> {

  /**
   * Returns the server state type.
   *
   * @return The server state type.
   */
  RaftServer.State type();

  /**
   * Handles a metadata request.
   *
   * @param request The request to handle.
   * @return A completable future to be completed with the request response.
   */
  CompletableFuture<MetadataResponse> metadata(MetadataRequest request);

  /**
   * Handles an open session request.
   *
   * @param request The request to handle.
   * @return A completable future to be completed with the request response.
   */
  CompletableFuture<OpenSessionResponse> openSession(OpenSessionRequest request);

  /**
   * Handles a keep alive request.
   *
   * @param request The request to handle.
   * @return A completable future to be completed with the request response.
   */
  CompletableFuture<KeepAliveResponse> keepAlive(KeepAliveRequest request);

  /**
   * Handles a close session request.
   *
   * @param request The request to handle.
   * @return A completable future to be completed with the request response.
   */
  CompletableFuture<CloseSessionResponse> closeSession(CloseSessionRequest request);

  /**
   * Handles a configure request.
   *
   * @param request The request to handle.
   * @return A completable future to be completed with the request response.
   */
  CompletableFuture<ConfigureResponse> configure(ConfigureRequest request);

  /**
   * Handles an install request.
   *
   * @param request The request to handle.
   * @return A completable future to be completed with the request response.
   */
  CompletableFuture<InstallResponse> install(InstallRequest request);

  /**
   * Handles a join request.
   *
   * @param request The request to handle.
   * @return A completable future to be completed with the request response.
   */
  CompletableFuture<JoinResponse> join(JoinRequest request);

  /**
   * Handles a configure request.
   *
   * @param request The request to handle.
   * @return A completable future to be completed with the request response.
   */
  CompletableFuture<ReconfigureResponse> reconfigure(ReconfigureRequest request);

  /**
   * Handles a leave request.
   *
   * @param request The request to handle.
   * @return A completable future to be completed with the request response.
   */
  CompletableFuture<LeaveResponse> leave(LeaveRequest request);

  /**
   * Handles an append request.
   *
   * @param request The request to handle.
   * @return A completable future to be completed with the request response.
   */
  CompletableFuture<AppendResponse> append(AppendRequest request);

  /**
   * Handles a poll request.
   *
   * @param request The request to handle.
   * @return A completable future to be completed with the request response.
   */
  CompletableFuture<PollResponse> poll(PollRequest request);

  /**
   * Handles a vote request.
   *
   * @param request The request to handle.
   * @return A completable future to be completed with the request response.
   */
  CompletableFuture<VoteResponse> vote(VoteRequest request);

  /**
   * Handles a command request.
   *
   * @param request The request to handle.
   * @return A completable future to be completed with the request response.
   */
  CompletableFuture<CommandResponse> command(CommandRequest request);

  /**
   * Handles a query request.
   *
   * @param request The request to handle.
   * @return A completable future to be completed with the request response.
   */
  CompletableFuture<QueryResponse> query(QueryRequest request);

}