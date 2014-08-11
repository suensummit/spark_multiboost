/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.mllib.classification.multilabel.stronglearners

import org.apache.spark.annotation.Experimental
import org.apache.spark.mllib.classification.multilabel.MultiLabeledPoint
import org.apache.spark.mllib.classification.multilabel.MultiLabelClassificationAlgorithm
import org.apache.spark.mllib.classification.multilabel.MultiLabelClassificationModel
import org.apache.spark.rdd.RDD

@Experimental
abstract class StrongLearnerModel[B <: MultiLabelClassificationModel]
    extends MultiLabelClassificationModel {
  def baseLearners: List[B]
}

@Experimental
abstract class StrongLearnerAlgorithm[BM <: MultiLabelClassificationModel, BA <: MultiLabelClassificationAlgorithm[BM], SM <: StrongLearnerModel[BM]]
    extends MultiLabelClassificationAlgorithm[SM] {
  def run(dataSet: RDD[MultiLabeledPoint]): SM
}
