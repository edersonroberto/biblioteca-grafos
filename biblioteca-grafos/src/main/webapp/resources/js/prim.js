var sys = arbor.ParticleSystem(1000, 400,1);
sys.parameters({gravity:true});
sys.renderer = Renderer("#viewport");
var a0= sys.addNode('a0', {'color':'green','label':'0'});
var a1= sys.addNode('a1', {'color':'green','label':'1'});
var a2= sys.addNode('a2', {'color':'green','label':'2'});
var a3= sys.addNode('a3', {'color':'green','label':'3'});
var a4= sys.addNode('a4', {'color':'green','label':'4'});
sys.addEdge('a0', 'a1',{'color':'green', 'weight':1});
sys.addEdge('a0', 'a2',{'color':'green', 'weight':1});
sys.addEdge('a0', 'a3',{'color':'red', 'weight':1});
sys.addEdge('a1', 'a0',{'color':'green', 'weight':1});
sys.addEdge('a1', 'a2',{'color':'red', 'weight':1});
sys.addEdge('a1', 'a3',{'color':'green', 'weight':1});
sys.addEdge('a2', 'a0',{'color':'green', 'weight':1});
sys.addEdge('a2', 'a1',{'color':'red', 'weight':1});
sys.addEdge('a2', 'a3',{'color':'red', 'weight':1});
sys.addEdge('a3', 'a0',{'color':'red', 'weight':1});
sys.addEdge('a3', 'a1',{'color':'green', 'weight':1});
sys.addEdge('a3', 'a2',{'color':'red', 'weight':1});
sys.addEdge('a3', 'a4',{'color':'red', 'weight':1});
sys.addEdge('a4', 'a3',{'color':'red', 'weight':1});
