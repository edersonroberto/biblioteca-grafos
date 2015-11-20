 var sys = arbor.ParticleSystem(1000, 400,1);
          sys.parameters({gravity:true});
          sys.renderer = Renderer("#viewport") ;
          var animals = sys.addNode('Animals',{'color':'red','shape':'dot','label':'Animals'});
          var dog = sys.addNode('dog',{'color':'green','shape':'dot','label':'dog'});
          var cat = sys.addNode('cat',{'color':'blue','shape':'dot','label':'cat'});
          var eagle = sys.addNode('eagle',{'color':'black','shape':'dot','label':'eagle','weight':40});
          
          sys.addEdge(animals, dog,{'color':'blue', 'weight':5});
          sys.addEdge(animals, cat,{'color':'red', 'weight':5});
          sys.addEdge(animals, eagle,{'color': 'orange', 'weight':5})