package scalajsplus

import scala.scalajs.js

class ReadonlyArrayTest extends BaseTest {

  test("should construct js.Array using Companion Apply") {
    val a = ReadonlyArray(1, 2, 3, 4)
    expect(a.length).toBe(4)
    expect(a(3)).toBe(4)
    expect(a).toMatchObject(js.Array(1, 2, 3, 4))
    expect(a.join()).toBe("1,2,3,4")
  }

  test("scalajs js.Array to Scala collection implicits should apply") {
    val a = ReadonlyArray(1, 2, 3, 4, 4, 5)
    expect(a.toList).toMatchObject(List(1, 2, 3, 4, 4))
    expect(a.toSet).toMatchObject(Set(1, 2, 3, 4, 5))
  }
}
