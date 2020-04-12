class Node:
    def __init__(self, data=None):
        self.data = data
        self.left = None
        self.right = None

class ExpressionTree:
    def __init__(self,head):
        self.head = None
    def evaluate(self,node):
        if node is None:
            return 0
        if node.left is None and node.right is None:
            return node.data
        l_val = self.evaluate(node.left)
        r_val = self.evaluate(node.right)

        if node.data == '+':
            return l_val + r_val
        elif node.data == '-':
            return l_val - r_val
        elif node.data == '*':
            return l_val * r_val
        elif node.data == '/':
            return l_val / r_val
        else:
            return 0

root = Node('+')

node1= Node('*')
node2= Node('*')
root.left = node1;
root.right = node2;

node3= Node(2)
node4= Node(3)
node1.left = node3
node1.right = node4

node5= Node(7)
node6= Node(1)
node2.left = node5
node2.right = node6

root.left = node1;
root.right = node2;

expressionTree = ExpressionTree(root)
value = expressionTree.evaluate(root)
print(value)