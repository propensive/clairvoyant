/*
    Anticipation, version 0.26.0. Copyright 2025 Jon Pretty, Propensive OÜ.

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

import prepositional.*

object Decodable:
  given Bytes is Decodable in Bytes = (value, omit) => value

trait Decodable:
  inline def decodable: this.type = this
  type Self
  type Format

  def decode(value: Format, omit: Boolean): Self

  def map[SelfType2](lambda: Self => SelfType2): SelfType2 is Decodable in Format =
    (value, omit) => lambda(decodable.decode(value, omit))
