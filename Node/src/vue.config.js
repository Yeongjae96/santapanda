module.exports = {  
    outputDir: "../src/main/resources/static",  // npm run build로 빌드 시 파일이 생성되는 위치
    indexPath: "../static/index.html",  // npm run build로 빌드 시 파일이 생성되는 위치
    devServer: {  
      proxy: "http://localhost:8080"  //  Back-End , 즉 Spring Boot의 내장 was의 주소를 작성하게 되면 된다.
    },  
    chainWebpack: config => {  
      const svgRule = config.module.rule("svg");    
      svgRule.uses.clear();    
      svgRule.use("vue-svg-loader").loader("vue-svg-loader");  
    }  
  };