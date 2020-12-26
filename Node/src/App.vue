<template> 
  <v-app class="app-wapper">
    <v-app-bar app></v-app-bar>
    <v-navigation-drawer app>
      <side-bar/>
    </v-navigation-drawer>
    <!-- <side-bar>
    </side-bar> -->
    <v-main app>
      <v-container fluid>
        <router-view/>
      </v-container>
    </v-main>
    <v-footer app>
      <!-- -->
    </v-footer>
  </v-app>


  <!-- <div id="app">
    
    <v-app-bar> 
      <v-toolbar-title class="headline text-uppercase">
        <span class="font-weight-light">MATERIAL DESIGN</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn
        text
        href="https://github.com/vuetifyjs/vuetify/releases/latest"
        target="_blank">
        <span class="mr-2">Latest Release</span>
      </v-btn>
    </v-app-bar>
    <v-main>
      <router-view/>  
    </v-main>
  </div> -->
</template>
<script> 
import sideBar from '@/components/layout/sideBar'
export default { 
  name: 'App',
  components: {
    sideBar
  }
}; 
</script>
<style>
.app-wrapper {
  position: relative;
  height: 100%;
  width: 100%;
  display: flex;
}
</style>