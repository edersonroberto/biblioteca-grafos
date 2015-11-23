var sys = arbor.ParticleSystem(1000, 400,1);
sys.parameters({gravity:true});
sys.renderer = Renderer("#viewport");
var a0= sys.addNode('a0', {'color':'blue','shape':'dot','label':'0'});
var a1= sys.addNode('a1', {'color':'blue','shape':'dot','label':'1'});
var a2= sys.addNode('a2', {'color':'blue','shape':'dot','label':'2'});
var a3= sys.addNode('a3', {'color':'blue','shape':'dot','label':'3'});
var a4= sys.addNode('a4', {'color':'blue','shape':'dot','label':'4'});
var a5= sys.addNode('a5', {'color':'blue','shape':'dot','label':'5'});
sys.addEdge('a0', 'a1',{'color':'red', 'weight':10});
sys.addEdge('a0', 'a2',{'color':'black', 'weight':20});
sys.addEdge('a1', 'a2',{'color':'black', 'weight':11});
sys.addEdge('a1', 'a3',{'color':'black', 'weight':13});
sys.addEdge('a2', 'a0',{'color':'black', 'weight':20});
sys.addEdge('a2', 'a3',{'color':'red', 'weight':12});
sys.addEdge('a2', 'a5',{'color':'red', 'weight':8});
sys.addEdge('a3', 'a0',{'color':'red', 'weight':14});
sys.addEdge('a3', 'a4',{'color':'red', 'weight':10});
sys.addEdge('a4', 'a5',{'color':'black', 'weight':5});
