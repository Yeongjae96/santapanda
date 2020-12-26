<template>
  <v-layout column justify-center>
    <v-flex>
      <h1 id="main-icon">Santa Panda!</h1>
    </v-flex>
    <v-flex>
      <v-card
        height="350px"
      >
        <v-list-item>
          <v-list-item-content>
            <v-list-item-title class="title">
              Application
            </v-list-item-title>
            <v-list-item-subtitle>
              subtext
            </v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>

        <v-divider></v-divider>

        <v-list
          dense
          nav>
          <v-list-item
            v-for="item in items"
            :key="item.title"
            link
          >
            <v-list-item-icon>
              <v-icon>{{ item.icon }}</v-icon>
            </v-list-item-icon>

            <v-list-item-content>
              <v-list-item-title>{{ item.title }}</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
        </v-list>
      </v-card>
    </v-flex>
  </v-layout>
</template>
<script>
export default {
  name: 'side-bar',
  props: {},
  data() {
    return {
      items: [
        { title: 'Home', icon: 'mdi-view-dashboard' },
        { title: 'About', icon: 'mdi-forum' },
      ],
      drawer: null,
    }
  }
}
</script>
<style scoped>
#main-icon {
  margin: 0px;
  width: 100%;
  height: 64px;
  border-bottom: 1px solid #202528;
}
</style>