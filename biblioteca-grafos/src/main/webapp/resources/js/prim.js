var sys = arbor.ParticleSystem(1000, 400,1);
sys.parameters({gravity:true});
sys.renderer = Renderer("#viewport");
var a0= sys.addNode('a0', {'color':'black','label':'0'});
var a1= sys.addNode('a1', {'color':'black','label':'1'});
var a2= sys.addNode('a2', {'color':'black','label':'2'});
var a3= sys.addNode('a3', {'color':'black','label':'3'});
var a4= sys.addNode('a4', {'color':'black','label':'4'});
var a5= sys.addNode('a5', {'color':'black','label':'5'});
sys.addEdge('a0', 'a1',{'color':'red', 'weight':2});
sys.addEdge('a0', 'a2',{'color':'green', 'weight':4});
sys.addEdge('a1', 'a2',{'color':'green', 'weight':2});
sys.addEdge('a1', 'a3',{'color':'green', 'weight':2});
sys.addEdge('a2', 'a0',{'color':'green', 'weight':4});
sys.addEdge('a2', 'a3',{'color':'red', 'weight':2});
sys.addEdge('a2', 'a5',{'color':'red', 'weight':1});
sys.addEdge('a3', 'a0',{'color':'red', 'weight':2});
sys.addEdge('a3', 'a4',{'color':'red', 'weight':2});
sys.addEdge('a4', 'a5',{'color':'green', 'weight':1});
