<template>
  <v-container>
    <v-card
      elevation="2"
      outlined
      tile
    >
      <v-card-title>Sign up Form</v-card-title>
      <v-card-text>
        <validation-observer
          ref="observer"
          v-slot="{ disabled }"
        >
          <v-form
          ref="form"
          @submit.prevent="submit"
          v-model="user.valid"
          lazy-validation>
          <validation-provider
            v-slot="{ errors }"
            name="userId"
            :rules="{
              required: true,
            }"
          >
            <v-text-field
              v-model="user.userId"
              :counter="20"
              :error-messages="errors"
              label="User ID"
              required
           ></v-text-field>
          </validation-provider>
          <validation-provider
            v-slot="{ errors }"
            name="password"
            :rules="{
              required: true,
            }"
          >
            <v-text-field
              v-model="user.password"
              :counter="20"
              :error-messages="errors"
              label="Password"
              type="password"
              required
           ></v-text-field>
          </validation-provider>
          <validation-provider
            v-slot="{ errors }"
            name="Name"
            rules="required|max:10"
          >
            <v-text-field
              v-model="user.name"
              :counter="10"
              :error-messages="errors"
              label="name"
              required
            ></v-text-field>
          </validation-provider>
          <validation-provider
            v-slot="{ errors }"
            name="phoneNumber"
            :rules="{
              required: true,
              digits: 7,
              regex: '^(71|72|74|76|81|82|84|85|86|87|88|89)\\d{5}$'
            }"
          >
            <v-text-field
              v-model="user.phoneNumber"
              :counter="7"
              :error-messages="errors"
              label="Phone Number"
              required
           ></v-text-field>
          </validation-provider>
          <validation-provider
            v-slot="{ errors }"
            name="email"
            rules="required|email">
            <v-text-field
              v-model="user.email"
              :error-messages="errors"
              label="E-mail"
              required
            ></v-text-field>
          </validation-provider>
          <div class="d-flex justify-center mb-6">
            <v-btn
              class="mr-4"
              type="submit"
              color="success"
              :disabled="disabled">
              Submit
            </v-btn>
            <v-btn @click="clear">
              Clear
            </v-btn>
          </div>
          </v-form>
        </validation-observer>
      </v-card-text>
    </v-card>
  </v-container>
</template>
<script>
export default {
  name: 'sign-up',
  props: {},
  data()  {
    return {
      user: {
        name: '',
        email: '',
        phoneNumber: '',
        userId: '',
        password: '',
        useYn: 'Y',
      },
      nameRules: [
         v => !!v || 'Name is required',
         v => (v && v.length <= 10) || 'Name must be  less than 10 characters',
      ],
      emailRules: [
        v => !!v || 'Email is required',
        v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
      ],
      disabled: false,
      valid: false,
    }
  },
  created() {
    Object.assign(this.$data, this.$options.data());
  },
  beforeMount() {

  },
  mounted() {
    this.init();
  },
  computed: {},
  watch: {},
  methods: {
    init() {
      // this.disabled = true;
    },
    async submit() {
      const validationCheck = await this.$refs.observer.validate();
      if (!validationCheck) return;
      this.$http.url = '/user';
      this.$http.method = 'post';
      this.$http.param = this.user;
      this.$http.request(
        _result => {
          console.log(_result);
        },
        _error => {
          console.log(_error);
        },
      )
    },
    validation() {
      return ;
    },
    clear() {
        this.user.name= '',
        this.user.email= '',
        this.user.phoneNumber= '',
        this.user.userId= '',
        this.user.password= '',
        this.user.useYn= 'Y',
      
      this.$refs.observer.reset();
    },
  },
}
</script>