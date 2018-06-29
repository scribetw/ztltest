/* B50_3013539Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B50

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B50_3013539Test extends ZTL4ScalaTestCase {
  @Test
  def testDisable() = {
    var zscript =
      """
		<zk>
		1. Please select "Item 2"
		<separator />
		2. Click the "disabled" button
		<separator />
		3. Click the "change label" button
		<separator />
		4. The "Item 2" should be replaced with "ABC".
		<separator />
		5. Click the "disabled" button
		<separator />
		6. All of the items should not be gray.
	
	
		<tree id="tree" width="400px" rows="8">
			<treecols sizable="true">
				<treecol label="Name" />
				<treecol label="Description" />
			</treecols>
			<treechildren>
				<treeitem>
					<treerow>
						<treecell label="Item 1" />
						<treecell label="Item 1 description" />
					</treerow>
					<treechildren>
						<treeitem>
							<treerow>
								<treecell id="tc" label="Item 2" />
								<treecell label="Item 2 description" />
							</treerow>
						</treeitem>
					</treechildren>
				</treeitem>
			</treechildren>
		</tree>
		<zscript>
		boolean b = true;
	</zscript>
		<button label="disabled">
			<attribute name="onClick"><![CDATA[
		Treeitem selectItem = tree.getSelectedItem();
		Collection c = tree.getItems();
		Iterator ir = c.iterator();
		while (ir.hasNext()) {
			Treeitem ti = (Treeitem) ir.next();
	
			if (selectItem != null && !selectItem.equals(ti)) {
				ti.setDisabled(b);
			}
		}
		b = !b;
	]]></attribute>
		</button>
		<button label="change label" onClick='tc.label = "ABC"' />
	</zk>
		 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val tree = ztl$engine.$f("tree")
    val tc = ztl$engine.$f("tc")
    runZTL(zscript, () => {
      click(jq("$tc"))
      waitResponse()
      click(jq("@button[label=\"disabled\"]"))
      waitResponse()
      click(jq("@button[label=\"change label\"]"))
      waitResponse()
      verifyContains(jq("$tc").text(), "ABC")
      click(jq("@button[label=\"disabled\"]"))
      waitResponse()
      verifyContains(jq("$tc").text(), "ABC")
    })
  }
}


