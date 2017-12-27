package scalajsplus

import org.scalajs.dom

import scala.scalajs.js

class ObservableTest extends BaseTest {

  test("shouldCreateObservableOfNumbers") {

    val arr = js.Array[Int]()
    val o = Observable
      .of(1, 2, 3, 4, 5)
      .subscribe((i: Int) => {
        arr.push(i)
      })

    expect(arr).toMatchObject(js.Array(1, 2, 3, 4, 5))

  }

}
