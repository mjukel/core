package scalajsplus.polyfills

import scala.scalajs.js
import scalajsplus.BaseTest

class ObjectAssignTest extends BaseTest {

  test("should throw Error when target is null") {
    val f: js.Function0[Any] =
      () => ObjectAssign(null, js.Dynamic.literal(id = 1))
    expect(f).toThrow()
  }

  test("shouldCopy source fields to  target") {

    val target = js.Dynamic.literal(id = 1, name = "hello")
    val source1 = js.Dynamic.literal(id = 2, name2 = "hello2")
    val source2 = js.Dynamic.literal(name = "hello3", age = 20)
    expect(ObjectAssign(target, source1, source2, null)).toMatchObject(
      js.Dynamic.literal(id = 2, name = "hello3", name2 = "hello2", age = 20))
  }

}
