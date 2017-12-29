package scalajsplus

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSBracketAccess, JSGlobal, JSName}

/***
  *  read only version of scalajs.js.Array
  * @tparam A
  */
@js.native
@JSGlobal
class ReadOnlyArray[A] extends js.Object with js.Iterable[A] {

  /** Length of the array. */
  def length: Int = js.native

  /** Access the element at the given index. */
  @JSBracketAccess
  def apply(index: Int): A = js.native

  /** <span class="badge badge-ecma6" style="float: right;">ECMAScript 6</span>
    *  JavaScript Iterator for this Array.
    */
  @JSName(js.Symbol.iterator)
  def jsIterator(): js.Iterator[A] = js.native

  /**
    * The join() method joins all elements of an array into a string.
    *
    * separator Specifies a string to separate each element of the array.
    * The separator is converted to a string if necessary. If omitted, the
    * array elements are separated with a comma.
    */
  def join(seperator: String = ","): String = js.native

}

object ReadOnlyArray {
  @inline
  def apply[A](items: A*): ReadOnlyArray[A] =
    js.Array(items: _*).asInstanceOf[ReadOnlyArray[A]]
}
