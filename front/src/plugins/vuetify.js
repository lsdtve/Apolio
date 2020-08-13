import Vue from 'vue'
import Vuetify, { VRow } from 'vuetify/lib'
// import colors from 'vuetify/lib/util/colors'

Vue.use(Vuetify, {
  components: { VRow },
})
export default new Vuetify({
  theme: {
    themes: {
      light: {
        primary: '#ff6b87',
        secondary: '#FFFFFF',
        accent: '#3AAA1D',
        error: '#ffeaee', 
        info: '#eaf9ff',
        success: '#f1eaff',
        warning: '#FFC107',
      },
    },
  },
})


// primary : 짙은 벚꽃
// secondary: 흰색
// accent: 월계수 초록
// Error : 연한벚꽃
// info : 연하늘색
// success: 에메랄드초록 (안씀)
// warning: 바나나노랑(안씀)