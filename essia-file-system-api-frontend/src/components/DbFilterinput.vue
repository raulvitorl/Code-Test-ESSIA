<template>
    <el-form :inline="true" :model="formInline">

        <el-form-item label="Entrar na Pasta">
            <el-select v-model="formInline.pai" clearable placeholder="Selecione"
                       v-on:visible-change="selectDemo">
                <el-option
                        v-for="(item, index) in type_options"
                        :key = "index"
                        :label="item.nomePasta"
                        :value="item.id">
                </el-option>
            </el-select>
        </el-form-item>
    </el-form>
    
</template>

<script>
    import lodash from 'lodash'
    import Bus from '../eventBus'

    export default {
        name: 'db-filterinput',
        data() {
            return {
                type_options: [],
                formInline: {
                    pai: '',
                    email: ''
                },
                formLabelWidth: '120px'
            }
        },

        watch: {
            'formInline.pai': 'filterResultData'
        },

        methods: {
            selectDemo: function (params) {
                if (params) {
                    this.$axios.get("http://127.0.0.1:8000/file-api/v1/pastas")
                        .then((response) => {
                            this.type_options = response.data.registros;
                            console.log(response.data);
                        }).catch(function (response) {
                        console.log(response)
                    });
                }

            },
            filterResultData: _.debounce(
                function () {
                    this.$axios.get("http://127.0.0.1:8000/file-api/v1/pastas", {
                        params: {
                            pai: this.formInline.pai,
                        }
                    }).then((response) => {
                        response.data['pai'] = this.formInline.pai;
                        
                        Bus.$emit('filterResultData', response.data);
                        console.log(response.data);
                    }).catch(function (response) {
                        console.log(response)
                    });

                },
                500
            ),
        }
    }


</script>
