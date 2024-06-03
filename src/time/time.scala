/*
    Anticipation, version [unreleased]. Copyright 2024 Jon Pretty, Propensive OÜ.

    The primary distribution site is: https://propensive.com/

    Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
    file except in compliance with the License. You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software distributed under the
    License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
    either express or implied. See the License for the specific language governing permissions
    and limitations under the License.
*/

package anticipation

import language.experimental.captureChecking

trait SpecificInstant:
  type Self
  def instant(millisecondsSinceEpoch: Long): Self

trait GenericInstant:
  type Self
  def millisecondsSinceEpoch(instant: Self): Long

trait SpecificDuration:
  type Self
  def duration(milliseconds: Long): Self

trait GenericDuration:
  type Self
  def milliseconds(duration: Self): Long

extension [InstantType: GenericInstant](instant: InstantType)
  def millisecondsSinceEpoch: Long = InstantType.millisecondsSinceEpoch(instant)

object SpecificInstant:
  def apply[InstantType: SpecificInstant](millisecondsSinceEpoch: Long): InstantType =
    InstantType.instant(millisecondsSinceEpoch)

  given Long is SpecificInstant = identity(_)

extension [DurationType: GenericDuration](duration: DurationType)
  def milliseconds: Long = DurationType.milliseconds(duration)

object SpecificDuration:
  def apply[DurationType: SpecificDuration](milliseconds: Long): DurationType =
    DurationType.duration(milliseconds)

  given Long is SpecificDuration = identity(_)

object GenericInstant:
  given Long is GenericInstant = identity(_)

object GenericDuration:
  given Long is GenericDuration = identity(_)
