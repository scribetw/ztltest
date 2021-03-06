/* Z60_F01416DefaultCommandTest.scala

	Purpose:
		
	Description:
		
	History:
		Nov 7, 2012 Created by Pao Wang

Copyright (C) 2012 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F01416DefaultCommandTest extends ZTL4ScalaTestCase {

  def testArg() = {
    val zul = """
      <include src="/bind/issue/F01416DefaultCommand.zul"/>
"""

    runZTL(zul, () => {

      var btn1 = jq("$btn1")
      var btn2 = jq("$btn2")
      var btng1 = jq("$btng1")
      var btng2 = jq("$btng2")
      var lb1 = jq("$lb1")

      var btn3 = jq("$btn3")
      var btn4 = jq("$btn4")
      var btng3 = jq("$btng3")
      var btng4 = jq("$btng4")
      var lb2 = jq("$lb2")

      verifyEquals("Dennis", lb1.toWidget().attr("value"))
      verifyEquals("Dennis", lb2.toWidget().attr("value"))

      click(btn1.toWidget())
      waitResponse()
      verifyEquals("do command1", lb1.toWidget().attr("value"))
      verifyEquals("Dennis", lb2.toWidget().attr("value"))

      click(btn2.toWidget())
      waitResponse()
      verifyEquals("do command cmd2", lb1.toWidget().attr("value"))
      verifyEquals("Dennis", lb2.toWidget().attr("value"))

      click(btng1.toWidget())
      waitResponse()
      verifyEquals("do globa-command1", lb1.toWidget().attr("value"))
      verifyEquals("do globa-command1", lb2.toWidget().attr("value"))

      click(btng2.toWidget())
      waitResponse()
      verifyEquals("do globa-command gcmd2", lb1.toWidget().attr("value"))
      verifyEquals("do globa-command gcmd2", lb2.toWidget().attr("value"))

      click(btn3.toWidget())
      waitResponse()
      verifyEquals("do globa-command gcmd2", lb1.toWidget().attr("value"))
      verifyEquals("do command3", lb2.toWidget().attr("value"))

      click(btn4.toWidget())
      waitResponse()
      verifyEquals("do globa-command gcmd2", lb1.toWidget().attr("value"))
      verifyEquals("do command cmd4", lb2.toWidget().attr("value"))

      click(btng3.toWidget())
      waitResponse()
      verifyEquals("do globa-command3", lb1.toWidget().attr("value"))
      verifyEquals("do globa-command3", lb2.toWidget().attr("value"))

      click(btng4.toWidget())
      waitResponse()
      verifyEquals("do globa-command gcmd4", lb1.toWidget().attr("value"))
      verifyEquals("do globa-command gcmd4", lb2.toWidget().attr("value"))

    })
  }
}
