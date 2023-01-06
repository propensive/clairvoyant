/*
    Anticipation, version 0.4.0. Copyright 2021-23 Jon Pretty, Propensive OÜ.

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

trait GenericUrl[T]:
  def readUrl(value: T): String
  def makeUrl(string: String): T

def readUrl[T](url: T)(using GenericUrl[T]): String = summon[GenericUrl[T]].readUrl(url)
def makeUrl[T](url: String)(using GenericUrl[T]): T = summon[GenericUrl[T]].makeUrl(url)

package urlRepresentation {}