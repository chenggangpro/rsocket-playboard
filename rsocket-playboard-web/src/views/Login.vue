<template xmlns:v-slot="http://www.w3.org/1999/XSL/Transform">
    <v-app >
        <v-content>
            <v-container class="fill-height main_app" fluid >
                <v-row align="center" justify="center">
                    <v-col cols="12" sm="8" md="4">
                        <v-card class="elevation-12">
                            <v-toolbar color="primary" dark flat>
                                <v-toolbar-title>Login</v-toolbar-title>
                            </v-toolbar>
                            <v-card-text>
                                <v-form>
                                    <v-text-field id="account" label="Account" name="account" prepend-icon="mdi-account" type="text"/>
                                    <v-text-field id="password" label="Password" name="password" prepend-icon="mdi-lock" type="password"/>
                                </v-form>
                            </v-card-text>
                            <v-card-actions>
                                <v-spacer />
                                <v-btn color="primary">Login</v-btn>
                            </v-card-actions>
                        </v-card>
                    </v-col>
                </v-row>
            </v-container>
        </v-content>
    </v-app>
</template>

<script>
    export default {
        props: {
            source: String,
        },
    }
</script>

<style>
    .main_app{
        background-image: url('../assets/login_background.jpg');
        background-repeat:no-repeat;
        background-size:100% 100%;
        -moz-background-size:100% 100%;
    }

</style>