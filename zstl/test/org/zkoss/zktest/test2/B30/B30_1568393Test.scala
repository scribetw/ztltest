/* B30_1568393Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1568393Test extends ZTL4ScalaTestCase {
  @Test
  def testDragdrop() = {
    var zscript =
      """
			<window title="Test" id="root">
			1. keep on clicking on the title-bar of the overlapped-window(not on the "close_button")
			<separator/>
			2. sometimes the window jumps to the upper right corner without dragging it.(If not, it is right)
			<zscript><![CDATA[
			public class ContentPanel extends Window implements EventListener{
				private Caption top;
				private Label closeLabel;
			
				public ContentPanel(){
					init0();
				}
			
				private void init0(){
					top = new Caption();
					top.setStyle("cursor:hand;");
				
					closeLabel = new Label();
					Label l = closeLabel;
					l.setValue("CLOSE X");
					//l.setId(ImageLoader.IMG_MINI);
					l.addEventListener("onClick", this);
				
					l.setStyle("cusror:position; cursor:hand;");
					top.appendChild(l);
					appendChild(top);	
				}
			
				public boolean setVisible(boolean v){
					if(!inOverlapped())
						doOverlapped();
					return super.setVisible(v);
				}
			
			
				public void onEvent(Event arg0) {
					if(arg0.getName().equals("onClick") &&
					(arg0.getTarget() instanceof Component) ){
						super.setVisible(false);
						arg0.stopPropagation();
						//EventHandler.get().notifyObservers(this, new CloseEvent());
					}
				}
			}
			
			
				ContentPanel cp = new ContentPanel();
				cp.setId("overlapped");
				cp.setTitle("hello");
				cp.setStyle("width: 400px; max-width: 400px; height: 350px; max-height: 350px; top:25%; left: 25%; position:absolute;");
				cp.setParent(root);
				cp.doOverlapped();
			]]></zscript>
			</window> 
		"""
    val ztl$engine = engine()
    val root = ztl$engine.$f("root")
    val overlapped = ztl$engine.$f("overlapped")
    runZTL(zscript, () => {
      var x = jq(overlapped).positionLeft()
      var y = jq(overlapped).positionTop()
      for (i <- 1 until 6) {
        dragdropTo(overlapped, "1" + i + ",2", "1" + (i + 1) + ",2")
      }
      var x2 = jq(overlapped).positionLeft()
      var y2 = jq(overlapped).positionTop()
      // after several mouse click, the root should not move it
      // position
      verifyEquals(x, x2)
      verifyEquals(y, y2)
    })
  }
}



