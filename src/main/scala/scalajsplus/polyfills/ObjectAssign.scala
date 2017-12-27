package scalajsplus.polyfills

import scala.scalajs.js
import scala.scalajs.js.{JavaScriptException, TypeError}

object ObjectAssign {

  def apply[T <: js.Object](target: T, sources: js.Object*): T = {

    if (target == null) {
      throw JavaScriptException(
        TypeError("Cannot convert undefined or null to object"))
    }

    sources.foreach(so => {
      if (so != null) {
        js.Object
          .keys(so)
          .foreach(key => {
            target
              .asInstanceOf[js.Dynamic]
              .updateDynamic(key)(
                so.asInstanceOf[js.Dynamic].selectDynamic(key))
          })
      }
    })
    target
  }

}
