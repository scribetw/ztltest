/* B30_1813278Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1813278Test extends ZTL4ScalaTestCase {
  @Test
  def testDatabind() = {
    var zscript =
      """
<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
<zk	xmlns:h="http://www.w3.org/1999/xhtml" xmlns:zk="http://www.zkoss.org/2005/zk">
<html><![CDATA[
Test xhtml with annotation databinding (support DynamicPropertied)<br/>
1. You should see 3 hyperlink below.<br/>
2. Move mouse cursor over each link and check on the browser status bar whether the hyperlink 
is the same as what is shown on the page<br/>
3. Press change link1 button, the 1st link should be changed from http://www.zkoss.org to http://www.potix.com.<br/>
4. Move mouse curson over the 1st link and check on the browser status bar whether the hyperlink is changed to http://www.potix.com, too.
]]></html>
<zscript>
	public class Link {
		private String _href;
		
		public Link(String href) {
			setLink(href);
		}
		
		public String getLink() {
			return _href;
		}
		
		public void setLink(String href) {
			_href = href;
		}
	}
	
	Link link1 = new Link("http://www.zkoss.org");
	Link link2 = new Link("http://jp.zkoss.org");
	Link link3 = new Link("http://zh.zkoss.org");
</zscript>
<h:ul>
<h:li id="li1" ><h:a href="@{link1.link}"><label value="@{link1.link}"/></h:a></h:li>
<h:li><h:a href="@{link2.link}"><label value="@{link2.link}"/></h:a></h:li>
<h:li><h:a href="@{link3.link}"><label value="@{link3.link}"/></h:a></h:li>
</h:ul>
<button id="btn" label="change link1">
	<attribute name="onClick">
		link1 = new Link("http://www.potix.com");
		binder.loadComponent(li1);
	</attribute>
</button>
</zk>

		 """
    val ztl$engine = engine()
    val li1 = ztl$engine.$f("li1")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      verifyEquals("http://www.zkoss.org", jq("a:eq(0)").attr("href"))
      verifyEquals("http://jp.zkoss.org", jq("a:eq(1)").attr("href"))
      verifyEquals("http://zh.zkoss.org", jq("a:eq(2)").attr("href"))
      click(btn)
      waitResponse()
      sleep(500)
      verifyEquals("http://www.potix.com", jq("a:eq(0)").attr("href"))
    })
  }
}



