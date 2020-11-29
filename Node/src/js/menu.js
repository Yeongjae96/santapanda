import axios from 'axios'

const menu = {};

axios.get('http://localhost:8000/api/menu')
    .then(_response => {
      console.log(_response.data);
      menu.list = _response.data;
    });

//1. 메뉴갖고온다.
//2. 순서가공해서 만든다. =? 

// function getComponent(path) {
//   return () => import(`@${path}`);
// }


export default menu;