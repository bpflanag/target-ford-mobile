/*
Copyright (c) Microsoft Open Technologies, Inc.
All Rights Reserved
Apache 2.0 License
 
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at
 
     http://www.apache.org/licenses/LICENSE-2.0
 
   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 
See the Apache Version 2.0 License for specific language governing permissions and limitations under the License.
 */

/**
 * InsertOperationCollapser.java
 */
package com.microsoft.windowsazure.mobileservices.table.sync.operations;

/**
 * Class that encapsulates collapse logic for existing insert operation
 */
class InsertOperationCollapser implements TableOperationVisitor<TableOperation> {
	private InsertOperation mExistingOperation;

	/**
	 * Constructor for InsertOperationCollapser
	 * 
	 * @param existingOperation
	 *            the existing operation to collapse
	 */
	InsertOperationCollapser(InsertOperation existingOperation) {
		this.mExistingOperation = existingOperation;
	}

	@Override
	public TableOperation visit(InsertOperation newOperation) {
		throw new IllegalStateException("An insert operation on the item is already in the queue.");
	}

	@Override
	public TableOperation visit(UpdateOperation newOperation) {
		return this.mExistingOperation;
	}

	@Override
	public TableOperation visit(DeleteOperation newOperation) {
		return null;
	}
}