package scalajsplus

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|
import scalajsplus.macros.FunctionObjectMacro
@js.native
@JSImport("zen-observable", JSImport.Default)
class Observable[T](
    subscriber: js.Function1[SubscriptionObserver,
                             js.Function0[Any] | Subscription])
    extends js.Object {

  def subscribe(observer: Observer[T]): Subscription = js.native

  def subscribe(onNext: js.Function1[T, Any],
                onError: js.Function1[js.Error, Any] = ???,
                onComplete: js.Function0[Any] = ???): Subscription =
    js.native

}

@js.native
trait Subscription extends js.Object {

  def unsubscribe(): Unit = js.native

  def closed(): Boolean = js.native

}

trait Observer[T] extends js.Object {
  val next: js.Function1[T, Any]
  val error: js.UndefOr[js.Function1[js.Error, Any]] = js.undefined
  val start: js.UndefOr[js.Function1[Subscription, Any]] = js.undefined
  val complete: js.UndefOr[js.Function0[Any]] = js.undefined
}

//object Observer {
//
//  def apply[T](
//      next: T => Unit,
//      error: OptionalParam[js.Error => Unit] = OptDefault,
//      complete: OptionalParam[() => Unit] = OptDefault,
//      start: OptionalParam[Subscription => Unit] = OptDefault): Observer[T] = {
//    val p = FunctionObjectMacro()
//    p.asInstanceOf[Observer[T]]
//  }
//}

@js.native
trait SubscriptionObserver extends js.Object {}
@js.native
@JSImport("zen-observable", JSImport.Default)
object Observable extends js.Object {

  def of[T](in: T*): Observable[T] = js.native

  def from[T](observable: Observable[T]): Observable[T] = js.native
}
