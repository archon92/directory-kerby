/**
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License. 
 *  
 */
package org.apache.kerby.asn1.parse;

import java.nio.ByteBuffer;

public class Asn1Item extends Asn1ParseResult {

    public Asn1Item(Asn1Header header, int bodyStart, ByteBuffer buffer) {
        super(header, bodyStart, buffer);
    }

    public byte[] readBodyBytes() {
        ByteBuffer bodyBuffer = getBodyBuffer();
        byte[] result = new byte[bodyBuffer.remaining()];
        bodyBuffer.get(result);
        return result;
    }

    @Override
    public String toString() {
        String valueStr = "##undecoded##";
        String typeStr = tag().isUniversal() ? tag().universalTag().toStr()
            : tag().tagClass().name().toLowerCase();
        return typeStr + " ["
            + "off=" + getOffset()
            + ", len=" + getHeaderLength() + "+" + getBodyLength()
            + "] "
            + valueStr;
    }
}
