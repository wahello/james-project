/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.james.events;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.UUID;

import org.apache.james.events.EventDeadLetters;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

class InsertionIdTest {
    private static final UUID UUID_1 = UUID.fromString("6e0dd59d-660e-4d9b-b22f-0354479f47b4");

    @Test
    void eventIdShouldMatchBeanContract() {
        EqualsVerifier.forClass(EventDeadLetters.InsertionId.class).verify();
    }

    @Test
    void ofShouldDeserializeUUIDs() {
        assertThat(EventDeadLetters.InsertionId.of(UUID_1.toString()))
            .isEqualTo(EventDeadLetters.InsertionId.of(UUID_1));
    }

    @Test
    void ofStringShouldThrowOnNullValue() {
        assertThatThrownBy(() -> EventDeadLetters.InsertionId.of((String) null))
            .isInstanceOf(NullPointerException.class);
    }

    @Test
    void ofUuidShouldThrowOnNullValue() {
        assertThatThrownBy(() -> EventDeadLetters.InsertionId.of((UUID) null))
            .isInstanceOf(NullPointerException.class);
    }
}