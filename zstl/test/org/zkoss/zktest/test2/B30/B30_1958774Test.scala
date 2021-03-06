/* B30_1958774Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1958774Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			


<window mode="overlapped" title="tree demo" border="normal" position="center" height="300px" width="400px">
 If you can see this page without any error, it's correct.
<zscript>
  <![CDATA[
    import java.util.Vector;
	import org.zkoss.zul.ext.TreeSelectableModel;
    public class treeModel extends AbstractTreeModel implements TreeSelectableModel {

      public treeModel (Vector treeData) {
	super(treeData);
      }

      public boolean isLeaf (Object node) {
	return !(node instanceof Vector);
      }

      public Object getChild (Object parent,int index) {
	Vector vec = (Vector) parent;
	if (vec==getRoot())
	  return vec.get(index);
	else
	  return vec.get(index+1);
      }

      public int getChildCount (Object parent) {
	Vector vec = (Vector) parent;
	if (vec==getRoot())
	  return vec.size();
	else
	  return vec.size()-1;
      }

	
	public void setMultiple(boolean multiple) {
		
	}

	
	public boolean isMultiple() {
		return false;
	}

	
	public void addSelectionPath(int[] path) {
		
	}

	
	public void addSelectionPaths(int[][] paths) {
		
	}

	
	public boolean removeSelectionPath(int[] path) {
		return false;
	}

	
	public boolean removeSelectionPaths(int[][] paths) {
		return false;
	}

	
	public boolean isPathSelected(int[] path) {
		return false;
	}

	
	public boolean isSelectionEmpty() {
		return false;
	}

	
	public void clearSelection() {
	}

	
	public int[] getSelectionPath() {
		return null;
	}

	
	public int[][] getSelectionPaths() {
		return null;
	}

	
	public int getSelectionCount() {
		return 0;
	}

    }

    TreeitemRenderer itemRenderer = new TreeitemRenderer () {
      public void render(Treeitem ti,Object data, int index) {
	Treerow tr = ti.getTreerow();
	// According to TreeitemRenderer docs, "a new treerow should be
	// contructed and append to treeitem, when treerow of treeitem is null.
	// Otherwise, when treerow of treeitem is not null, modify the content
	// of the treerow or detach the treerow's children first, since that
	// only one treerow is allowed."
	//
	if (tr==null) {
	  tr = new Treerow();
	  tr.setParent(ti);
	} else {
	  while (tr.getChildren().size()>0) {
	    ((Component)tr.getChildren().get(0)).detach();
	  }
	}

	if (data instanceof Vector) {
	  String label = (String) ((Vector) data).get(0);
	  Treecell tc = new Treecell(label);
	  tc.setParent(tr);
	  // Exception thrown if we try to do setOpen here:
	  ti.setOpen(true);
	} else {
	  String label = (String) data;
	  Treecell tc = new Treecell(label);
	  tc.setParent(tr);
	}
      }
    };

    public class myTree extends Tree {
      public myTree () {
	//
	// Compose the tree model as a vector of vectors.  Each vector inside
	// the root vector stores the label of the branch in the first value,
	// and remaining values are labels for the child nodes.
	Vector treeData = new Vector();

	// Make the first branch.
	Vector branch1 = new Vector();
	treeData.add(branch1);
	branch1.add("BRANCH1");
	branch1.add("node1");
	branch1.add("node2");

	// Make a second branch.
	Vector branch2 = new Vector();
	treeData.add(branch2);
	branch2.add("BRANCH2");
	branch2.add("node1");
	branch2.add("node2");

	treeModel tm = new treeModel(treeData);
        setTreeitemRenderer(itemRenderer);
	setModel(tm);
      }
    }

    myTree tree = new myTree();
    tree.setParent(self);
  ]]>
  </zscript>
</window>


		"""
    val ztl$engine = engine()
    runZTL(zscript, () => {
      verifyTrue(jq("@window[title=\"tree demo\"]").exists())
      verifyFalse(jq("@window:not(@window[title=\"tree demo\"])").exists())
    })
  }
}



