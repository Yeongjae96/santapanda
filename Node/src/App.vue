<template> 
  <div id="app">
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
  </div>
</template>
<script> 

export default { 
  name: 'App' 
}; 
</script>